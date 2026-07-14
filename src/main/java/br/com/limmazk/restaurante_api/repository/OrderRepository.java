package br.com.limmazk.restaurante_api.repository;

import br.com.limmazk.restaurante_api.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
