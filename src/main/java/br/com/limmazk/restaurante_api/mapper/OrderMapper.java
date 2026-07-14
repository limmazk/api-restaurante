package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.OrderResponseDTO;
import br.com.limmazk.restaurante_api.model.Order;

public class OrderMapper {

    public static OrderResponseDTO toResponseDTO(Order order) {
        return new OrderResponseDTO(
                order.getId(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getTotalPrice(),
                order.getClient().getId()
        );
    }
}
