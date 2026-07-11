package br.com.limmazk.restaurante_api.model;

import br.com.limmazk.restaurante_api.enums.DishCategory;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String description;
    private String name;
    private BigDecimal price;
    private Integer preparationTime;
    private DishCategory category;
    private Boolean available;

    @OneToMany(mappedBy = "dish")
    private List<OrderItem> items;
}
