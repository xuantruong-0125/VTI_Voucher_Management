package org.example.voucher_manager.presentation.controller.api;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateVoucherRequest;
import org.example.voucher_manager.application.dto.request.UpdateVoucherRequest;
import org.example.voucher_manager.application.dto.response.ApiResponse;
import org.example.voucher_manager.application.dto.response.VoucherResponse;
import org.example.voucher_manager.application.service.VoucherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vouchers")
@RequiredArgsConstructor
public class VoucherController {

    private final VoucherService voucherService;

    @PostMapping
    public ApiResponse<VoucherResponse> create(
            @RequestBody CreateVoucherRequest request
    ) {

        VoucherResponse response = voucherService.create(request);

        return ApiResponse.success(
                "Create voucher successfully",
                response
        );
    }

    @PutMapping("/{id}")
    public ApiResponse<VoucherResponse> update(
            @PathVariable Long id,
            @RequestBody UpdateVoucherRequest request
    ) {

        VoucherResponse response =
                voucherService.update(id, request);

        return ApiResponse.success(
                "Update voucher successfully",
                response
        );
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(
            @PathVariable Long id
    ) {

        voucherService.delete(id);

        return ApiResponse.success(
                "Delete voucher successfully",
                null
        );
    }

    @GetMapping("/{id}")
    public ApiResponse<VoucherResponse> getById(
            @PathVariable Long id
    ) {

        VoucherResponse response =
                voucherService.getById(id);

        return ApiResponse.success(
                "Get voucher successfully",
                response
        );
    }

    @GetMapping
    public ApiResponse<List<VoucherResponse>> getAll() {

        List<VoucherResponse> responses =
                voucherService.getAll();

        return ApiResponse.success(
                "Get voucher list successfully",
                responses
        );
    }

    @GetMapping("/search")
    public ApiResponse<VoucherResponse> findByCode(
            @RequestParam String code
    ) {

        VoucherResponse response =
                voucherService.findByCode(code);

        return ApiResponse.success(
                "Find voucher successfully",
                response
        );
    }
}