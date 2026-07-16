package br.com.limmazk.restaurante_api.controller;

import br.com.limmazk.restaurante_api.dto.DeliveryRequestDTO;
import br.com.limmazk.restaurante_api.dto.DeliveryResponseDTO;
import br.com.limmazk.restaurante_api.service.DeliveryService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/deliveries")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService){
        this.deliveryService = deliveryService;
    }

    @GetMapping
    public ResponseEntity<List<DeliveryResponseDTO>> getAll(){
        return ResponseEntity.ok(deliveryService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DeliveryResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(deliveryService.getById(id));
    }

    @PostMapping
    public ResponseEntity<DeliveryResponseDTO> create(@RequestBody @Valid DeliveryRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(deliveryService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        deliveryService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
