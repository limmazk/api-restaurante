package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.PaymentResponseDTO;
import br.com.limmazk.restaurante_api.model.Payment;

public class PaymentMapper {

    public static PaymentResponseDTO toResponseDTO(Payment payment) {
        return new PaymentResponseDTO(
                payment.getId(),
                payment.getOrder().getId(),
                payment.getTotalPrice()
        );
    }
}
