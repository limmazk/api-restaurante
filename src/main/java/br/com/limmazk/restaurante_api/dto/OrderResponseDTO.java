package br.com.limmazk.restaurante_api.dto;

import br.com.limmazk.restaurante_api.enums.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponseDTO(

        UUID id,
        OrderStatus status,
        LocalDateTime createdAt,
        BigDecimal totalPrice,
        UUID clientId

) {
}