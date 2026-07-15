package br.com.limmazk.restaurante_api.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record PaymentResponseDTO(

        UUID id,
        UUID orderId,
        BigDecimal totalPrice
) {
}
