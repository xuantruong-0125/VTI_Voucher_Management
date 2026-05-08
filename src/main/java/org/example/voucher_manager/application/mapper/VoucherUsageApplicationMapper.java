package org.example.voucher_manager.application.mapper;

import org.example.voucher_manager.application.dto.response.VoucherUsageResponse;
import org.example.voucher_manager.domain.entity.Voucher;
import org.example.voucher_manager.domain.entity.VoucherUsage;

public class VoucherUsageApplicationMapper {

    private VoucherUsageApplicationMapper() {
    }

    public static VoucherUsageResponse toResponse(
            VoucherUsage voucherUsage,
            Voucher voucher
    ) {

        VoucherUsageResponse response =
                new VoucherUsageResponse();

        response.setUsageId(voucherUsage.getId());
        response.setUserId(voucherUsage.getUserId());
        response.setVoucherId(voucherUsage.getVoucherId());
        response.setUsedAt(voucherUsage.getUsedAt());
        response.setRemainingQuantity(voucher.getQuantity());

        return response;
    }
}