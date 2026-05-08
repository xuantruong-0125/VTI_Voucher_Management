package org.example.voucher_manager.application.dto.request;

public class UseVoucherRequest {

    private Long userId;

    private Long voucherId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getVoucherId() {
        return voucherId;
    }

    public void setVoucherId(Long voucherId) {
        this.voucherId = voucherId;
    }
}