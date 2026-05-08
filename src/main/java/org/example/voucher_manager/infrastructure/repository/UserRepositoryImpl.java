package org.example.voucher_manager.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.domain.entity.User;
import org.example.voucher_manager.domain.repository.UserRepository;
import org.example.voucher_manager.infrastructure.persistence.entity.UserJpaEntity;
import org.example.voucher_manager.infrastructure.persistence.mapper.UserPersistenceMapper;
import org.example.voucher_manager.infrastructure.persistence.repository.UserJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository userJpaRepository;

    @Override
    public User save(User user) {

        UserJpaEntity entity =
                UserPersistenceMapper.toPersistence(user);

        UserJpaEntity savedEntity =
                userJpaRepository.save(entity);

        return UserPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public List<User> findAll() {

        return userJpaRepository.findAll()
                .stream()
                .map(UserPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public Optional<User> findById(Long id) {

        return userJpaRepository.findById(id)
                .map(UserPersistenceMapper::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {

        return userJpaRepository.findByEmail(email)
                .map(UserPersistenceMapper::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {

        return userJpaRepository.existsByEmail(email);
    }
}