package org.example.voucher_manager.application.service;

import org.example.voucher_manager.application.dto.request.UseVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherUsageResponse;

import java.util.List;

public interface VoucherUsageService {

    VoucherUsageResponse useVoucher(
            UseVoucherRequest request
    );

    List<VoucherUsageResponse> getAll();
}