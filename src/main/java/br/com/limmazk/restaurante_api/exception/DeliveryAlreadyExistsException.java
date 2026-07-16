package br.com.limmazk.restaurante_api.exception;

public class DeliveryAlreadyExistsException extends RuntimeException {
    public DeliveryAlreadyExistsException(String message) {
        super(message);
    }
}
