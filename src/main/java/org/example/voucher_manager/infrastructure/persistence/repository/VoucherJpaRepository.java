package org.example.voucher_manager.infrastructure.persistence.repository;

import org.example.voucher_manager.infrastructure.persistence.entity.VoucherJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface VoucherJpaRepository
        extends JpaRepository<VoucherJpaEntity, Long> {

    Optional<VoucherJpaEntity> findByCode(String code);

    boolean existsByCode(String code);
}