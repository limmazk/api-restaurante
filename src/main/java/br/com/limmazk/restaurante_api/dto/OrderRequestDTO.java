package br.com.limmazk.restaurante_api.dto;

import java.util.List;
import java.util.UUID;

public record OrderRequestDTO(

        UUID clientId,

        List<OrderItemRequestDTO> items

) {
}