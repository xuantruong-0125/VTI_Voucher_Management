package org.example.voucher_manager.application.mapper;

import org.example.voucher_manager.application.dto.request.CreateVoucherRequest;
import org.example.voucher_manager.application.dto.request.UpdateVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherResponse;
import org.example.voucher_manager.domain.constant.VoucherStatus;
import org.example.voucher_manager.domain.entity.Voucher;

public class VoucherApplicationMapper {

    private VoucherApplicationMapper() {
    }

    public static Voucher toEntity(CreateVoucherRequest request) {

        Voucher voucher = new Voucher();

        voucher.setCode(request.getCode());
        voucher.setDiscountPercent(request.getDiscountPercent());
        voucher.setQuantity(request.getQuantity());
        voucher.setExpiredDate(request.getExpiredDate());
        voucher.setStatus(VoucherStatus.ACTIVE);

        return voucher;
    }

    public static void updateEntity(
            Voucher voucher,
            UpdateVoucherRequest request
    ) {

        voucher.setCode(request.getCode());
        voucher.setDiscountPercent(request.getDiscountPercent());
        voucher.setQuantity(request.getQuantity());
        voucher.setExpiredDate(request.getExpiredDate());
    }

    public static VoucherResponse toResponse(Voucher voucher) {

        VoucherResponse response = new VoucherResponse();

        response.setId(voucher.getId());
        response.setCode(voucher.getCode());
        response.setDiscountPercent(voucher.getDiscountPercent());
        response.setQuantity(voucher.getQuantity());
        response.setExpiredDate(voucher.getExpiredDate());
        response.setStatus(voucher.getStatus());
        response.setCreatedAt(voucher.getCreatedAt());

        return response;
    }
}