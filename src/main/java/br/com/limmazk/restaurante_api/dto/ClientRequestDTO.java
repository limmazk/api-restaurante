package br.com.limmazk.restaurante_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ClientRequestDTO(
        @NotBlank
        String name,

        @NotNull
        String email,

        @NotNull
        String address,

        @Pattern(
                regexp = "^\\(?\\d{2}\\)?\\s?9?\\d{4}-?\\d{4}$",
                message = "Telefone inválido."
        )
        String phone
) {
}
