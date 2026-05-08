package org.example.voucher_manager.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateUserRequest;
import org.example.voucher_manager.application.dto.response.UserResponse;
import org.example.voucher_manager.application.mapper.UserApplicationMapper;
import org.example.voucher_manager.application.service.UserService;
import org.example.voucher_manager.domain.entity.User;
import org.example.voucher_manager.domain.exception.UserAlreadyExistsException;
import org.example.voucher_manager.domain.exception.UserNotFoundException;
import org.example.voucher_manager.domain.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse create(CreateUserRequest request) {

        if (userRepository.existsByEmail(request.getEmail())) {
            throw new UserAlreadyExistsException(request.getEmail());
        }

        User user = UserApplicationMapper.toEntity(request);

        user.validate();

        User savedUser = userRepository.save(user);

        return UserApplicationMapper.toResponse(savedUser);
    }

    @Override
    public List<UserResponse> getAll() {

        return userRepository.findAll()
                .stream()
                .map(UserApplicationMapper::toResponse)
                .toList();
    }

    @Override
    public UserResponse getById(Long id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        return UserApplicationMapper.toResponse(user);
    }
}