package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.DishResponseDTO;
import br.com.limmazk.restaurante_api.mapper.DishMapper;
import br.com.limmazk.restaurante_api.model.Dish;
import br.com.limmazk.restaurante_api.repository.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository){
        this.dishRepository = dishRepository;
    }

    public List<DishResponseDTO> getAll() {

        List<Dish> dishes = dishRepository.findAll();

        return dishRepository.findAll()
                .stream()
                .map(DishMapper::toResponseDTO)
                .toList();
    }
}
