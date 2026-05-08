package org.example.voucher_manager.presentation.advice;

import org.example.voucher_manager.application.dto.response.ApiResponse;
import org.example.voucher_manager.domain.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // ===== VOUCHER =====

    @ExceptionHandler(VoucherAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleVoucherAlreadyExists(
            VoucherAlreadyExistsException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(VoucherNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleVoucherNotFound(
            VoucherNotFoundException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(VoucherExpiredException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleVoucherExpired(
            VoucherExpiredException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(VoucherInactiveException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleVoucherInactive(
            VoucherInactiveException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(VoucherOutOfStockException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleVoucherOutOfStock(
            VoucherOutOfStockException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(InvalidDiscountPercentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleInvalidDiscount(
            InvalidDiscountPercentException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(InvalidQuantityException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleInvalidQuantity(
            InvalidQuantityException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(VoucherExpiredDateException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleExpiredDate(
            VoucherExpiredDateException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    // ===== USER =====

    @ExceptionHandler(UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleUserAlreadyExists(
            UserAlreadyExistsException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(UserNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ApiResponse<Void> handleUserNotFound(
            UserNotFoundException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    @ExceptionHandler(InvalidEmailFormatException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiResponse<Void> handleInvalidEmail(
            InvalidEmailFormatException ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }

    // ===== COMMON =====

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ApiResponse<Void> handleException(
            Exception ex
    ) {

        return ApiResponse.error(ex.getMessage());
    }
}