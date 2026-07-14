package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.OrderItemResponseDTO;
import br.com.limmazk.restaurante_api.dto.OrderResponseDTO;
import br.com.limmazk.restaurante_api.model.Order;
import br.com.limmazk.restaurante_api.model.OrderItem;

import java.util.List;

public class OrderMapper {

    public static OrderItemResponseDTO toItemResponseDTO(OrderItem item) {

        return new OrderItemResponseDTO(
                item.getId(),
                item.getDish().getId(),
                item.getQuantity(),
                item.getUnitPrice()
        );
    }


    public static OrderResponseDTO toResponseDTO(Order order) {

        List<OrderItemResponseDTO> items = order.getItems()
                .stream()
                .map(OrderMapper::toItemResponseDTO)
                .toList();


        return new OrderResponseDTO(
                order.getId(),
                order.getStatus(),
                order.getCreatedAt(),
                order.getTotalPrice(),
                order.getClient().getId(),
                items
        );
    }
}
