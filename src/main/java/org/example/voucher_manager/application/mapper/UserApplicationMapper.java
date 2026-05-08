package org.example.voucher_manager.application.mapper;

import org.example.voucher_manager.application.dto.request.CreateUserRequest;
import org.example.voucher_manager.application.dto.response.UserResponse;
import org.example.voucher_manager.domain.entity.User;

public class UserApplicationMapper {

    private UserApplicationMapper() {
    }

    public static User toEntity(CreateUserRequest request) {

        User user = new User();

        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());

        return user;
    }

    public static UserResponse toResponse(User user) {

        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setFullName(user.getFullName());
        response.setEmail(user.getEmail());
        response.setPhone(user.getPhone());
        response.setCreatedAt(user.getCreatedAt());

        return response;
    }
}