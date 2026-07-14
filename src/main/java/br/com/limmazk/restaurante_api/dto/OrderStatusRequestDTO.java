package br.com.limmazk.restaurante_api.dto;

import br.com.limmazk.restaurante_api.enums.OrderStatus;

public record OrderStatusRequestDTO(
        OrderStatus status
) {
}