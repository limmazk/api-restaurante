package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.PaymentRequestDTO;
import br.com.limmazk.restaurante_api.dto.PaymentResponseDTO;
import br.com.limmazk.restaurante_api.exception.PaymentAlreadyExistsException;
import br.com.limmazk.restaurante_api.exception.ResourceNotFoundException;
import br.com.limmazk.restaurante_api.mapper.PaymentMapper;
import br.com.limmazk.restaurante_api.model.Order;
import br.com.limmazk.restaurante_api.model.Payment;
import br.com.limmazk.restaurante_api.repository.OrderRepository;
import br.com.limmazk.restaurante_api.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;

    public PaymentService(PaymentRepository paymentRepository,
                          OrderRepository orderRepository) {
        this.paymentRepository = paymentRepository;
        this.orderRepository = orderRepository;
    }

    public PaymentResponseDTO create(PaymentRequestDTO dto) {

        Order order = orderRepository.findById(dto.orderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found."));

        if (order.getPayment() != null) {
            throw new PaymentAlreadyExistsException("Order already has a payment.");
        }

        Payment payment = new Payment();

        payment.setOrder(order);
        payment.setTotalPrice(order.getTotalPrice());

        Payment paymentSaved = paymentRepository.save(payment);

        return PaymentMapper.toResponseDTO(paymentSaved);
    }

    public List<PaymentResponseDTO> getAll() {

        List<Payment> payments = paymentRepository.findAll();

        return payments.stream()
                .map(PaymentMapper::toResponseDTO)
                .toList();
    }

    public PaymentResponseDTO getById(UUID id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found."));

        return PaymentMapper.toResponseDTO(payment);
    }

    public void delete(UUID id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment not found."));

        paymentRepository.delete(payment);
    }
}
