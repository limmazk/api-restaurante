package br.com.limmazk.restaurante_api.dto;

import br.com.limmazk.restaurante_api.enums.DishCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record DishRequestDTO(

        @NotBlank
        String name,

        @NotBlank
        String description,

        @NotNull @Positive
        BigDecimal price,

        @NotNull @Positive
        Integer preparationTime,

        @NotNull
        DishCategory category,

        @NotNull
        Boolean available) {
}
