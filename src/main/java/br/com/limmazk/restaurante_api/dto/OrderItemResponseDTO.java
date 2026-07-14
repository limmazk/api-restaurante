package br.com.limmazk.restaurante_api.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderItemResponseDTO(

        UUID id,
        UUID dishId,
        Integer quantity,
        BigDecimal unitPrice
) {
}
