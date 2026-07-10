package br.com.limmazk.restaurante_api.model;

import br.com.limmazk.restaurante_api.enums.PaymentMethod;
import br.com.limmazk.restaurante_api.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private BigDecimal totalPrice;
    private PaymentStatus status;
    private PaymentMethod method;
}
