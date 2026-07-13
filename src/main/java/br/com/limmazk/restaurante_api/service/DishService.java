package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.DishRequestDTO;
import br.com.limmazk.restaurante_api.dto.DishResponseDTO;
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
            .orElseThrow(() -> new RuntimeException("Not found ID."));
        return DishMapper.toResponseDTO(dish); /*
        anotacao para estudo, aqui como o mapper ta em static, nao precisa injetar aqui,
        e no return era obrigado retornar um ResponseDTO, pq disse no começo do metódo que
        seria um ResponseDTO, então chamei o Mapper e usei uma function dele, que é o toResponse,
        e ai transformei o dish(que é a Entity) em DTO utilizando esse metodo pronto.
        */
    }

    public DishResponseDTO create(DishRequestDTO dto){
        Dish dish = DishMapper.toEntity(dto);
        Dish savedDish = dishRepository.save(dish);
        return DishMapper.toResponseDTO(savedDish); /*
        anotar que esse código recebe o ResquestDTO, que o cliente manda pra aplicação, e
        o metodo toEntity do mapper, faz a mudança de DTO para Entity, e assim consegue salvar no banco de dados.
        Mas depois que a Entity é salva no banco de dados, automaticamente já tem um return mandando de volta essa entity
        que foi transformada em ResponseDTO por meio do metodo do Mapper, que faz essa funçao.
        NAO ESQUECER DE CRIAR A PASTA DE EXCEPTIONS E VER O EXCEPTION PARA ADICIONAR AQUI
        */
    }
}
