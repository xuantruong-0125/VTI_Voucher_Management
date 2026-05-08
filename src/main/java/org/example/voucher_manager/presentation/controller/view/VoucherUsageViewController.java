package org.example.voucher_manager.presentation.controller.view;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.UseVoucherRequest;
import org.example.voucher_manager.application.dto.response.UserResponse;
import org.example.voucher_manager.application.dto.response.VoucherResponse;
import org.example.voucher_manager.application.dto.response.VoucherUsageResponse;
import org.example.voucher_manager.application.service.UserService;
import org.example.voucher_manager.application.service.VoucherService;
import org.example.voucher_manager.application.service.VoucherUsageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/voucher-usages")
@RequiredArgsConstructor
public class VoucherUsageViewController {

    private final VoucherUsageService voucherUsageService;
    private final UserService userService;
    private final VoucherService voucherService;

    @GetMapping("/use")
    public String useForm(Model model) {

        List<UserResponse> users =
                userService.getAll();

        List<VoucherResponse> vouchers =
                voucherService.getAll();

        model.addAttribute("users", users);
        model.addAttribute("vouchers", vouchers);

        model.addAttribute(
                "voucherUsage",
                new UseVoucherRequest()
        );

        return "voucher-usages/form";
    }

    @PostMapping("/use")
    public String useVoucher(
            @ModelAttribute UseVoucherRequest request,
            Model model
    ) {

        try {

            voucherUsageService.useVoucher(request);

            return "redirect:/voucher-usages/use?success";

        } catch (Exception e) {

            List<UserResponse> users =
                    userService.getAll();

            List<VoucherResponse> vouchers =
                    voucherService.getAll();

            model.addAttribute("users", users);
            model.addAttribute("vouchers", vouchers);

            model.addAttribute(
                    "voucherUsage",
                    request
            );

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            return "voucher-usages/form";
        }
    }

    @GetMapping
    public String list(Model model) {

        List<VoucherUsageResponse> usages =
                voucherUsageService.getAll();

        model.addAttribute("usages", usages);

        return "voucher-usages/list";
    }
}