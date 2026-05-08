package org.example.voucher_manager.infrastructure.repository;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.domain.entity.VoucherUsage;
import org.example.voucher_manager.domain.repository.VoucherUsageRepository;
import org.example.voucher_manager.infrastructure.persistence.entity.VoucherUsageJpaEntity;
import org.example.voucher_manager.infrastructure.persistence.mapper.VoucherUsagePersistenceMapper;
import org.example.voucher_manager.infrastructure.persistence.repository.VoucherUsageJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class VoucherUsageRepositoryImpl
        implements VoucherUsageRepository {

    private final VoucherUsageJpaRepository
            voucherUsageJpaRepository;

    @Override
    public VoucherUsage save(
            VoucherUsage voucherUsage
    ) {

        VoucherUsageJpaEntity entity =
                VoucherUsagePersistenceMapper
                        .toPersistence(voucherUsage);

        VoucherUsageJpaEntity savedEntity =
                voucherUsageJpaRepository.save(entity);

        return VoucherUsagePersistenceMapper
                .toDomain(savedEntity);
    }

    @Override
    public List<VoucherUsage> findAll() {

        return voucherUsageJpaRepository.findAll()
                .stream()
                .map(VoucherUsagePersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public List<VoucherUsage> findByUserId(Long userId) {

        return voucherUsageJpaRepository
                .findByUserId(userId)
                .stream()
                .map(VoucherUsagePersistenceMapper::toDomain)
                .toList();
    }

    @Override
    public List<VoucherUsage> findByVoucherId(
            Long voucherId
    ) {

        return voucherUsageJpaRepository
                .findByVoucherId(voucherId)
                .stream()
                .map(VoucherUsagePersistenceMapper::toDomain)
                .toList();
    }
}