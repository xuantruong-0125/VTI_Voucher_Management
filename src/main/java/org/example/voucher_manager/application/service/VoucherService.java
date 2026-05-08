package org.example.voucher_manager.application.service;

import org.example.voucher_manager.application.dto.request.CreateVoucherRequest;
import org.example.voucher_manager.application.dto.request.UpdateVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherResponse;

import java.util.List;

public interface VoucherService {

    VoucherResponse create(CreateVoucherRequest request);

    VoucherResponse update(Long id, UpdateVoucherRequest request);

    void delete(Long id);

    VoucherResponse getById(Long id);

    List<VoucherResponse> getAll();

    VoucherResponse findByCode(String code);
}