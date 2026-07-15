package br.com.limmazk.restaurante_api.controller;

import br.com.limmazk.restaurante_api.dto.OrderRequestDTO;
import br.com.limmazk.restaurante_api.dto.OrderResponseDTO;
import br.com.limmazk.restaurante_api.dto.OrderStatusRequestDTO;
import br.com.limmazk.restaurante_api.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDTO>> getAll(){
        return ResponseEntity.ok(orderService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(orderService.getById(id));
    }

    @PostMapping
    public ResponseEntity<OrderResponseDTO> create(@RequestBody @Valid OrderRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(orderService.create(dto));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<OrderResponseDTO> updateStatus(
            @PathVariable UUID id,
            @RequestBody OrderStatusRequestDTO dto){

        return ResponseEntity.ok(orderService.updateStatus(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        orderService.delete(id);
        return  ResponseEntity.noContent().build();
    }
}
