package br.com.limmazk.restaurante_api.dto;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record PaymentRequestDTO(

        @NotNull
        UUID orderId
) {
}