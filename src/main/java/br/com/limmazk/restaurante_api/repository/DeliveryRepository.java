package br.com.limmazk.restaurante_api.repository;

import br.com.limmazk.restaurante_api.model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DeliveryRepository extends JpaRepository<Delivery, UUID> {
}
