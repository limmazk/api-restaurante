package br.com.limmazk.restaurante_api.dto;

import br.com.limmazk.restaurante_api.enums.DishCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.UUID;

public record DishResponseDTO(
        UUID id,
        String description,
        String name,
        BigDecimal price,
        Integer preparationTime,
        DishCategory category,
        Boolean available
) {
}
