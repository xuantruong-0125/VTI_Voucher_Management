package org.example.voucher_manager.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.domain.entity.Voucher;
import org.example.voucher_manager.domain.repository.VoucherRepository;
import org.example.voucher_manager.infrastructure.persistence.entity.VoucherJpaEntity;
import org.example.voucher_manager.infrastructure.persistence.mapper.VoucherPersistenceMapper;
import org.example.voucher_manager.infrastructure.persistence.repository.VoucherJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class VoucherRepositoryImpl implements VoucherRepository {

    private final VoucherJpaRepository voucherJpaRepository;

    @Override
    public Voucher save(Voucher voucher) {

        VoucherJpaEntity entity =
                VoucherPersistenceMapper.toPersistence(voucher);

        VoucherJpaEntity savedEntity =
                voucherJpaRepository.save(entity);

        return VoucherPersistenceMapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Voucher> findById(Long id) {

        return voucherJpaRepository.findById(id)
                .map(VoucherPersistenceMapper::toDomain);
    }

    @Override
    public Optional<Voucher> findByCode(String code) {

        return voucherJpaRepository.findByCode(code)
                .map(VoucherPersistenceMapper::toDomain);
    }

    @Override
    public List<Voucher> findAll() {

        return voucherJpaRepository.findAll()
                .stream()
                .map(VoucherPersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public void deleteById(Long id) {

        voucherJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsByCode(String code) {

        return voucherJpaRepository.existsByCode(code);
    }
}