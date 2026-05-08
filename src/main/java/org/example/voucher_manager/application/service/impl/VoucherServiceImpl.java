package org.example.voucher_manager.application.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.voucher_manager.application.dto.request.CreateVoucherRequest;
import org.example.voucher_manager.application.dto.request.UpdateVoucherRequest;
import org.example.voucher_manager.application.dto.response.VoucherResponse;
import org.example.voucher_manager.application.mapper.VoucherApplicationMapper;
import org.example.voucher_manager.application.service.VoucherService;
import org.example.voucher_manager.domain.entity.Voucher;
import org.example.voucher_manager.domain.exception.VoucherAlreadyExistsException;
import org.example.voucher_manager.domain.exception.VoucherNotFoundException;
import org.example.voucher_manager.domain.repository.VoucherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoucherServiceImpl implements VoucherService {

    private final VoucherRepository voucherRepository;

    @Override
    public VoucherResponse create(CreateVoucherRequest request) {

        if (voucherRepository.existsByCode(request.getCode())) {
            throw new VoucherAlreadyExistsException(request.getCode());
        }

        Voucher voucher = VoucherApplicationMapper.toEntity(request);

        voucher.validate();

        Voucher savedVoucher = voucherRepository.save(voucher);

        return VoucherApplicationMapper.toResponse(savedVoucher);
    }

    @Override
    public VoucherResponse update(Long id, UpdateVoucherRequest request) {

        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new VoucherNotFoundException(id));

        voucherRepository.findByCode(request.getCode())
                .ifPresent(existingVoucher -> {
                    if (!existingVoucher.getId().equals(id)) {
                        throw new VoucherAlreadyExistsException(request.getCode());
                    }
                });

        VoucherApplicationMapper.updateEntity(voucher, request);

        voucher.validate();

        Voucher updatedVoucher = voucherRepository.save(voucher);

        return VoucherApplicationMapper.toResponse(updatedVoucher);
    }

    @Override
    public void delete(Long id) {

        voucherRepository.findById(id)
                .orElseThrow(() -> new VoucherNotFoundException(id));

        voucherRepository.deleteById(id);
    }

    @Override
    public VoucherResponse getById(Long id) {

        Voucher voucher = voucherRepository.findById(id)
                .orElseThrow(() -> new VoucherNotFoundException(id));

        return VoucherApplicationMapper.toResponse(voucher);
    }

    @Override
    public List<VoucherResponse> getAll() {

        return voucherRepository.findAll()
                .stream()
                .map(VoucherApplicationMapper::toResponse)
                .toList();
    }

    @Override
    public VoucherResponse findByCode(String code) {

        Voucher voucher = voucherRepository.findByCode(code)
                .orElseThrow(() -> new RuntimeException("Voucher not found"));

        return VoucherApplicationMapper.toResponse(voucher);
    }
}