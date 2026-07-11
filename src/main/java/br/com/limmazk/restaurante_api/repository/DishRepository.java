package br.com.limmazk.restaurante_api.repository;

import br.com.limmazk.restaurante_api.model.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface DishRepository extends JpaRepository<Dish, UUID> {
}
