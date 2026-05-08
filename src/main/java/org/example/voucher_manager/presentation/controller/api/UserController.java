package org.example.voucher_manager.presentation.controller.api;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateUserRequest;
import org.example.voucher_manager.application.dto.response.ApiResponse;
import org.example.voucher_manager.application.dto.response.UserResponse;
import org.example.voucher_manager.application.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ApiResponse<UserResponse> create(
            @RequestBody CreateUserRequest request
    ) {

        UserResponse response = userService.create(request);

        return ApiResponse.success(
                "Create user successfully",
                response
        );
    }

    @GetMapping
    public ApiResponse<List<UserResponse>> getAll() {

        List<UserResponse> responses =
                userService.getAll();

        return ApiResponse.success(
                "Get user list successfully",
                responses
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponse> getById(
            @PathVariable Long id
    ) {

        UserResponse response =
                userService.getById(id);

        return ApiResponse.success(
                "Get user successfully",
                response
        );
    }
}