package br.com.limmazk.restaurante_api.dto;

import java.util.UUID;

public record ClientResponseDTO(
        UUID id,
        String name,
        String email,
        String address,
        String phone
) {
}
