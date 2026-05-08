package org.example.voucher_manager.presentation.controller.view;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateVoucherRequest;
import org.example.voucher_manager.application.dto.request.UpdateVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherResponse;
import org.example.voucher_manager.application.service.VoucherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("/vouchers")
@RequiredArgsConstructor
public class VoucherViewController {

    private final VoucherService voucherService;

    @GetMapping
    public String list(
            @RequestParam(required = false) String keyword,
            Model model
    ) {

        List<VoucherResponse> vouchers;

        try {

            if (keyword != null && !keyword.isBlank()) {

                VoucherResponse voucher =
                        voucherService.findByCode(keyword);

                vouchers = Collections.singletonList(voucher);

            } else {

                vouchers = voucherService.getAll();
            }

        } catch (Exception e) {

            vouchers = Collections.emptyList();

            model.addAttribute(
                    "error",
                    "Voucher not found"
            );
        }

        model.addAttribute("vouchers", vouchers);
        model.addAttribute("keyword", keyword);

        return "vouchers/list";
    }

    @GetMapping("/create")
    public String createForm(Model model) {

        model.addAttribute(
                "voucher",
                new CreateVoucherRequest()
        );

        model.addAttribute("voucherId", null);
        model.addAttribute("isEdit", false);

        return "vouchers/form";
    }

    @PostMapping("/create")
    public String create(
            @ModelAttribute CreateVoucherRequest request,
            Model model
    ) {

        validateVoucher(
                request.getDiscountPercent(),
                request.getQuantity(),
                request.getExpiredDate(),
                model
        );

        if (model.containsAttribute("error")) {

            model.addAttribute("voucher", request);
            model.addAttribute("voucherId", null);
            model.addAttribute("isEdit", false);

            return "vouchers/form";
        }

        try {

            voucherService.create(request);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            model.addAttribute("voucher", request);
            model.addAttribute("voucherId", null);
            model.addAttribute("isEdit", false);

            return "vouchers/form";
        }

        return "redirect:/vouchers";
    }

    @GetMapping("/edit/{id}")
    public String editForm(
            @PathVariable Long id,
            Model model
    ) {

        VoucherResponse voucher =
                voucherService.getById(id);

        model.addAttribute("voucher", voucher);
        model.addAttribute("voucherId", id);
        model.addAttribute("isEdit", true);

        return "vouchers/form";
    }

    @PostMapping("/edit/{id}")
    public String update(
            @PathVariable Long id,
            @ModelAttribute UpdateVoucherRequest request,
            Model model
    ) {

        validateVoucher(
                request.getDiscountPercent(),
                request.getQuantity(),
                request.getExpiredDate(),
                model
        );

        if (model.containsAttribute("error")) {

            model.addAttribute("voucher", request);
            model.addAttribute("voucherId", id);
            model.addAttribute("isEdit", true);

            return "vouchers/form";
        }

        try {

            voucherService.update(id, request);

        } catch (Exception e) {

            model.addAttribute(
                    "error",
                    e.getMessage()
            );

            model.addAttribute("voucher", request);
            model.addAttribute("voucherId", id);
            model.addAttribute("isEdit", true);

            return "vouchers/form";
        }

        return "redirect:/vouchers";
    }

    @GetMapping("/delete/{id}")
    public String delete(
            @PathVariable Long id
    ) {

        voucherService.delete(id);

        return "redirect:/vouchers";
    }

    private void validateVoucher(
            Integer discountPercent,
            Integer quantity,
            LocalDate expiredDate,
            Model model
    ) {

        if (discountPercent == null
                || discountPercent < 1
                || discountPercent > 100) {

            model.addAttribute(
                    "error",
                    "Discount percent must be from 1 to 100"
            );

            return;
        }

        if (quantity == null
                || quantity < 0) {

            model.addAttribute(
                    "error",
                    "Quantity must be greater than or equal to 0"
            );

            return;
        }

        if (expiredDate == null
                || !expiredDate.isAfter(LocalDate.now())) {

            model.addAttribute(
                    "error",
                    "Expired date must be greater than current date"
            );
        }
    }
}