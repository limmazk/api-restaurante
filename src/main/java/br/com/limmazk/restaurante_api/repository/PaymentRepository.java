package br.com.limmazk.restaurante_api.repository;

import br.com.limmazk.restaurante_api.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PaymentRepository extends JpaRepository<Payment, UUID> {
}
