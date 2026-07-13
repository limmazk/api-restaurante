package br.com.limmazk.restaurante_api.controller;

import br.com.limmazk.restaurante_api.dto.DishRequestDTO;
import br.com.limmazk.restaurante_api.dto.DishResponseDTO;
import br.com.limmazk.restaurante_api.model.Dish;
import br.com.limmazk.restaurante_api.service.DishService;
import jakarta.validation.Valid;
import org.hibernate.validator.cfg.defs.UUIDDef;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/dishes")
public class DishController {

    private final DishService dishService;

    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    @GetMapping
    public ResponseEntity<List<DishResponseDTO>> getAll(){
        return ResponseEntity.ok(dishService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DishResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(dishService.findById(id));
    }

    @PostMapping
    public ResponseEntity<DishResponseDTO> saveDish(@RequestBody @Valid DishRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(dishService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){

        dishService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<DishResponseDTO> update(@PathVariable UUID id, @RequestBody @Valid DishRequestDTO dto){
        return ResponseEntity.ok(dishService.update(id, dto));
    }

}
