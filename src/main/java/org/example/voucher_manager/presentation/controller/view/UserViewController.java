package org.example.voucher_manager.presentation.controller.view;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateUserRequest;
import org.example.voucher_manager.application.dto.response.UserResponse;
import org.example.voucher_manager.application.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserViewController {

    private final UserService userService;

    private static final String EMAIL_REGEX =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";

    @GetMapping
    public String list(Model model) {

        List<UserResponse> users =
                userService.getAll();

        model.addAttribute("users", users);

        return "users/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute(
                "user",
                new CreateUserRequest()
        );

        return "users/form";
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute CreateUserRequest request,
            Model model
    ) {

        validateUser(
                request.getEmail(),
                model
        );

        if (model.containsAttribute("error")) {

            model.addAttribute("user", request);

            return "users/form";
        }

        try {

            userService.create(request);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            model.addAttribute("user", request);

            return "users/form";
        }

        return "redirect:/users";
    }

    private void validateUser(
            String email,
            Model model
    ) {

        if (email == null
                || email.isBlank()) {

            model.addAttribute(
                    "error",
                    "Email is required"
            );

            return;
        }

        boolean isValidEmail =
                Pattern.matches(
                        EMAIL_REGEX,
                        email
                );

        if (!isValidEmail) {

            model.addAttribute(
                    "error",
                    "Invalid email format"
            );
        }
    }
}