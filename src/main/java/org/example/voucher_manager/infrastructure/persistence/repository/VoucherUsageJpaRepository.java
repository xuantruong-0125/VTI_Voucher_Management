package org.example.voucher_manager.infrastructure.persistence.repository;

import org.example.voucher_manager.infrastructure.persistence.entity.VoucherUsageJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoucherUsageJpaRepository
        extends JpaRepository<VoucherUsageJpaEntity, Long> {

    List<VoucherUsageJpaEntity> findByUserId(Long userId);

    List<VoucherUsageJpaEntity> findByVoucherId(Long voucherId);
}