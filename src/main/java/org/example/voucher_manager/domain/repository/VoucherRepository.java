package org.example.voucher_manager.domain.repository;


import org.example.voucher_manager.domain.entity.Voucher;

import java.util.List;
import java.util.Optional;

public interface VoucherRepository {

    Voucher save(Voucher voucher);

    Optional<Voucher> findById(Long id);

    Optional<Voucher> findByCode(String code);

    List<Voucher> findAll();

    void deleteById(Long id);

    boolean existsByCode(String code);
}
