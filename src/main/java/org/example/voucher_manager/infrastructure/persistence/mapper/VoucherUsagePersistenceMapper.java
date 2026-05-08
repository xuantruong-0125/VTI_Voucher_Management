package org.example.voucher_manager.infrastructure.persistence.mapper;

import org.example.voucher_manager.domain.entity.VoucherUsage;
import org.example.voucher_manager.infrastructure.persistence.entity.VoucherUsageJpaEntity;

public class VoucherUsagePersistenceMapper {

    private VoucherUsagePersistenceMapper() {
    }

    public static VoucherUsage toDomain(
            VoucherUsageJpaEntity entity
    ) {

        VoucherUsage voucherUsage =
                new VoucherUsage();

        voucherUsage.setId(entity.getId());
        voucherUsage.setUserId(entity.getUserId());
        voucherUsage.setVoucherId(entity.getVoucherId());
        voucherUsage.setUsedAt(entity.getUsedAt());

        return voucherUsage;
    }

    public static VoucherUsageJpaEntity toPersistence(
            VoucherUsage voucherUsage
    ) {

        VoucherUsageJpaEntity entity =
                new VoucherUsageJpaEntity();

        entity.setId(voucherUsage.getId());
        entity.setUserId(voucherUsage.getUserId());
        entity.setVoucherId(voucherUsage.getVoucherId());
        entity.setUsedAt(voucherUsage.getUsedAt());

        return entity;
    }
}