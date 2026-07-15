package br.com.limmazk.restaurante_api.dto;

import java.util.UUID;

public record PaymentRequestDTO(

        UUID orderId
) {
}