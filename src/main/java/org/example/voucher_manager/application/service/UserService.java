package org.example.voucher_manager.application.service;

import org.example.voucher_manager.application.dto.request.CreateUserRequest;
import org.example.voucher_manager.application.dto.response.UserResponse;

import java.util.List;

public interface UserService {

    UserResponse create(CreateUserRequest request);

    List<UserResponse> getAll();

    UserResponse getById(Long id);
}