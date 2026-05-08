package org.example.voucher_manager.infrastructure.persistence.mapper;

import org.example.voucher_manager.domain.entity.Voucher;
import org.example.voucher_manager.infrastructure.persistence.entity.VoucherJpaEntity;

public class VoucherPersistenceMapper {

    private VoucherPersistenceMapper() {
    }

    public static Voucher toDomain(VoucherJpaEntity entity) {

        Voucher voucher = new Voucher();

        voucher.setId(entity.getId());
        voucher.setCode(entity.getCode());
        voucher.setDiscountPercent(entity.getDiscountPercent());
        voucher.setQuantity(entity.getQuantity());
        voucher.setExpiredDate(entity.getExpiredDate());
        voucher.setStatus(entity.getStatus());
        voucher.setCreatedAt(entity.getCreatedAt());

        return voucher;
    }

    public static VoucherJpaEntity toPersistence(Voucher voucher) {

        VoucherJpaEntity entity = new VoucherJpaEntity();

        entity.setId(voucher.getId());
        entity.setCode(voucher.getCode());
        entity.setDiscountPercent(voucher.getDiscountPercent());
        entity.setQuantity(voucher.getQuantity());
        entity.setExpiredDate(voucher.getExpiredDate());
        entity.setStatus(voucher.getStatus());
        entity.setCreatedAt(voucher.getCreatedAt());

        return entity;
    }
}