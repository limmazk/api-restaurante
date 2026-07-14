package br.com.limmazk.restaurante_api.mapper;

import br.com.limmazk.restaurante_api.dto.DishRequestDTO;
import br.com.limmazk.restaurante_api.dto.DishResponseDTO;
import br.com.limmazk.restaurante_api.model.Dish;

public class DishMapper {

    public static Dish toEntity(DishRequestDTO dishRequestDTO){

        Dish dish = new Dish();

        dish.setName(dishRequestDTO.name());
        dish.setDescription(dishRequestDTO.description());
        dish.setPrice(dishRequestDTO.price());
        dish.setPreparationTime(dishRequestDTO.preparationTime());
        dish.setCategory(dishRequestDTO.category());
        dish.setAvailable(dishRequestDTO.available());

        return dish;
    }

    public static DishResponseDTO toResponseDTO(Dish dish) {
        return new DishResponseDTO(
                dish.getId(),
                dish.getDescription(),
                dish.getName(),
                dish.getPrice(),
                dish.getPreparationTime(),
                dish.getCategory(),
                dish.getAvailable()
        );
    }

    public static void updateEntity(DishRequestDTO dto, Dish dish){
        dish.setName(dto.name());
        dish.setDescription(dto.description());
        dish.setPrice(dto.price());
        dish.setPreparationTime(dto.preparationTime());
        dish.setCategory(dto.category());
        dish.setAvailable(dto.available());
    }
}
