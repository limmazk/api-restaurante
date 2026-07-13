package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.DishRequestDTO;
import br.com.limmazk.restaurante_api.dto.DishResponseDTO;
import br.com.limmazk.restaurante_api.exception.ResourceNotFoundException;
import br.com.limmazk.restaurante_api.mapper.DishMapper;
import br.com.limmazk.restaurante_api.model.Dish;
import br.com.limmazk.restaurante_api.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public List<DishResponseDTO> getAll() {
        List<Dish> dishes = dishRepository.findAll();

        return dishes.stream()
                .map(DishMapper::toResponseDTO)
                .toList();
    }

    public DishResponseDTO findById(UUID id){
        Dish dish = dishRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Dish not found."));
        return DishMapper.toResponseDTO(dish);
    }

    public DishResponseDTO create(DishRequestDTO dto){
        Dish dish = DishMapper.toEntity(dto);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.toResponseDTO(savedDish);
    }

    public DishResponseDTO update(UUID id, DishRequestDTO dto){
        Dish dish = dishRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("ID not found."));

        dish.setName(dto.name());
        dish.setDescription(dto.description());
        dish.setPrice(dto.price());
        dish.setPreparationTime(dto.preparationTime());
        dish.setCategory(dto.category());
        dish.setAvailable(dto.available());

        dishRepository.save(dish);

        return DishMapper.toResponseDTO(dish);
    }

    public void delete(UUID id){
        Dish dish = dishRepository.findById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("ID not found."));
        dishRepository.delete(dish);
    }
}
