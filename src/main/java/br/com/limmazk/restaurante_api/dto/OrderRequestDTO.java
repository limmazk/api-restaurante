package br.com.limmazk.restaurante_api.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(

        @NotNull
        UUID clientId,

        @NotEmpty
        List<OrderItemRequestDTO> items

) {
}