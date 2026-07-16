package br.com.limmazk.restaurante_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record DeliveryRequestDTO(

        @NotNull
        UUID orderId,

        @NotBlank
        String deliveryPerson
) {
}
