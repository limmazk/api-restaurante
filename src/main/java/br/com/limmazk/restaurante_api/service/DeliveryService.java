package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.DeliveryRequestDTO;
import br.com.limmazk.restaurante_api.dto.DeliveryResponseDTO;
import br.com.limmazk.restaurante_api.enums.DeliveryStatus;
import br.com.limmazk.restaurante_api.exception.DeliveryAlreadyExistsException;
import br.com.limmazk.restaurante_api.exception.ResourceNotFoundException;
import br.com.limmazk.restaurante_api.mapper.DeliveryMapper;
import br.com.limmazk.restaurante_api.model.Delivery;
import br.com.limmazk.restaurante_api.model.Order;
import br.com.limmazk.restaurante_api.repository.DeliveryRepository;
import br.com.limmazk.restaurante_api.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final OrderRepository orderRepository;

    public DeliveryService(
            DeliveryRepository deliveryRepository,
            OrderRepository orderRepository) {

        this.deliveryRepository = deliveryRepository;
        this.orderRepository = orderRepository;
    }

    @Transactional
    public DeliveryResponseDTO create(DeliveryRequestDTO dto) {

        Order order = orderRepository.findById(dto.orderId())
                .orElseThrow(() -> new ResourceNotFoundException("Order not found."));

        if (order.getDelivery() != null) {
            throw new DeliveryAlreadyExistsException("Order already has a delivery.");
        }

        Delivery delivery = new Delivery();
        delivery.setOrder(order);
        delivery.setDeliveryPerson(dto.deliveryPerson());
        delivery.setStatus(DeliveryStatus.WAITING);
        delivery.setDepartureTime(null);
        delivery.setDeliveredAt(null);

        Delivery deliverySaved = deliveryRepository.save(delivery);

        return DeliveryMapper.toResponseDTO(deliverySaved);
    }

    public List<DeliveryResponseDTO> getAll() {

        List<Delivery> deliveries = deliveryRepository.findAll();

        return deliveries.stream()
                .map(DeliveryMapper::toResponseDTO)
                .toList();
    }

    public DeliveryResponseDTO getById(UUID id) {

        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found."));

        return DeliveryMapper.toResponseDTO(delivery);
    }

    public void delete(UUID id) {

        Delivery delivery = deliveryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Delivery not found."));

        deliveryRepository.delete(delivery);
    }
}
