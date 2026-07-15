package br.com.limmazk.restaurante_api.exception;

public class PaymentAlreadyExistsException extends RuntimeException {

    public PaymentAlreadyExistsException(String message) {
        super(message);
    }
}