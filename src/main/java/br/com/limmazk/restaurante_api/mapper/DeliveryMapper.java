package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.DeliveryResponseDTO;
import br.com.limmazk.restaurante_api.model.Delivery;

public class DeliveryMapper {

    public static DeliveryResponseDTO toResponseDTO(Delivery delivery) {

        return new DeliveryResponseDTO(
                delivery.getId(),
                delivery.getOrder().getId(),
                delivery.getDeliveryPerson(),
                delivery.getDepartureTime(),
                delivery.getDeliveredAt(),
                delivery.getStatus()
        );
    }
}
