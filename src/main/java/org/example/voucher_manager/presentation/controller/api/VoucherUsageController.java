package org.example.voucher_manager.presentation.controller.api;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.UseVoucherRequest;
import org.example.voucher_manager.application.dto.response.ApiResponse;
import org.example.voucher_manager.application.dto.response.VoucherUsageResponse;
import org.example.voucher_manager.application.service.VoucherUsageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/voucher-usages")
@RequiredArgsConstructor
public class VoucherUsageController {

    private final VoucherUsageService voucherUsageService;

    @PostMapping("/use")
    public ApiResponse<VoucherUsageResponse> useVoucher(
            @RequestBody UseVoucherRequest request
    ) {

        VoucherUsageResponse response =
                voucherUsageService.useVoucher(request);

        return ApiResponse.success(
                "Use voucher successfully",
                response
        );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<VoucherUsageResponse>>>
    getAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Get voucher usages successfully",
                        voucherUsageService.getAll()
                )
        );
    }
}