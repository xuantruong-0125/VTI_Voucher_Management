package org.example.voucher_manager.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.UseVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherUsageResponse;
import org.example.voucher_manager.application.mapper.VoucherUsageApplicationMapper;
import org.example.voucher_manager.application.service.VoucherUsageService;
import org.example.voucher_manager.domain.entity.User;
import org.example.voucher_manager.domain.entity.Voucher;
import org.example.voucher_manager.domain.entity.VoucherUsage;
import org.example.voucher_manager.domain.exception.UserNotFoundException;
import org.example.voucher_manager.domain.exception.VoucherNotFoundException;
import org.example.voucher_manager.domain.repository.UserRepository;
import org.example.voucher_manager.domain.repository.VoucherRepository;
import org.example.voucher_manager.domain.repository.VoucherUsageRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoucherUsageServiceImpl
        implements VoucherUsageService {

    private final UserRepository userRepository;

    private final VoucherRepository voucherRepository;

    private final VoucherUsageRepository voucherUsageRepository;

    @Override
    @Transactional
    public VoucherUsageResponse useVoucher(
            UseVoucherRequest request
    ) {

        // ===== FIND USER =====

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new UserNotFoundException(request.getUserId()));

        // ===== FIND VOUCHER =====

        Voucher voucher = voucherRepository
                .findById(request.getVoucherId())
                .orElseThrow(() ->
                        new VoucherNotFoundException(
                                request.getVoucherId()
                        ));

        // ===== VALIDATE BUSINESS =====

        voucher.validateCanUseVoucher();

        // ===== DECREASE QUANTITY =====

        voucher.decreaseQuantity();

        Voucher updatedVoucher =
                voucherRepository.save(voucher);

        // ===== SAVE HISTORY =====

        VoucherUsage voucherUsage = new VoucherUsage();

        voucherUsage.setUserId(user.getId());
        voucherUsage.setVoucherId(voucher.getId());

        VoucherUsage savedUsage =
                voucherUsageRepository.save(voucherUsage);

        // ===== RESPONSE =====

        return VoucherUsageApplicationMapper.toResponse(
                savedUsage,
                updatedVoucher
        );

    }

    @Override
    public List<VoucherUsageResponse> getAll() {

        List<VoucherUsage> voucherUsages =
                voucherUsageRepository.findAll();

        return voucherUsages.stream()
                .map(voucherUsage -> {

                    Voucher voucher =
                            voucherRepository.findById(
                                    voucherUsage.getVoucherId()
                            ).orElseThrow(
                                    () -> new RuntimeException(
                                            "Voucher not found"
                                    )
                            );

                    return VoucherUsageApplicationMapper
                            .toResponse(
                                    voucherUsage,
                                    voucher
                            );
                })
                .toList();
    }
}