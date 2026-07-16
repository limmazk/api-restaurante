package br.com.limmazk.restaurante_api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.util.UUID;

public record OrderItemRequestDTO(

        @NotNull
        UUID dishId,

        @NotNull
        @Positive
        Integer quantity

) {
}
