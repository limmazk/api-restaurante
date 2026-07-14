package br.com.limmazk.restaurante_api.repository;

import br.com.limmazk.restaurante_api.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, UUID> {
}
