package br.com.limmazk.restaurante_api.model;

import br.com.limmazk.restaurante_api.enums.DeliveryStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Delivery {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @OneToOne
    @JoinColumn(name = "order_id")
    private Order order;

    private String deliveryPerson;

    private LocalDateTime departureTime;

    private LocalDateTime deliveredAt;

    private DeliveryStatus status;
}
