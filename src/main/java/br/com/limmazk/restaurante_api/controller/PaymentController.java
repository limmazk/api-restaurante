package br.com.limmazk.restaurante_api.controller;

import br.com.limmazk.restaurante_api.dto.PaymentRequestDTO;
import br.com.limmazk.restaurante_api.dto.PaymentResponseDTO;
import br.com.limmazk.restaurante_api.service.PaymentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<List<PaymentResponseDTO>> getAll(){
        return ResponseEntity.ok(paymentService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PaymentResponseDTO> getById(@PathVariable UUID id){
        return ResponseEntity.ok(paymentService.getById(id));
    }

    @PostMapping
    public ResponseEntity<PaymentResponseDTO> create(@RequestBody @Valid PaymentRequestDTO dto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(paymentService.create(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable UUID id){
        paymentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
