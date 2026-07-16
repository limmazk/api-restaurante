package br.com.limmazk.restaurante_api.dto;

import br.com.limmazk.restaurante_api.enums.DeliveryStatus;

import java.time.LocalDateTime;
import java.util.UUID;

public record DeliveryResponseDTO(

        UUID id,
        UUID orderId,
        String deliveryPerson,
        LocalDateTime departureTime,
        LocalDateTime deliveredAt,
        DeliveryStatus status
) {
}
