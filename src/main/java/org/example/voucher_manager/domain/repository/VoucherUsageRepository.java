package org.example.voucher_manager.domain.repository;

import org.example.voucher_manager.domain.entity.VoucherUsage;

import java.util.List;

public interface VoucherUsageRepository {

    VoucherUsage save(VoucherUsage voucherUsage);

    List<VoucherUsage> findAll();

    List<VoucherUsage> findByUserId(Long userId);

    List<VoucherUsage> findByVoucherId(Long voucherId);
}