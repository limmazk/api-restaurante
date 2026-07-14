package br.com.limmazk.restaurante_api.service;

import br.com.limmazk.restaurante_api.dto.OrderItemRequestDTO;
import br.com.limmazk.restaurante_api.dto.OrderRequestDTO;
import br.com.limmazk.restaurante_api.dto.OrderResponseDTO;
import br.com.limmazk.restaurante_api.enums.OrderStatus;
import br.com.limmazk.restaurante_api.exception.ResourceNotFoundException;
import br.com.limmazk.restaurante_api.mapper.OrderMapper;
import br.com.limmazk.restaurante_api.model.Client;
import br.com.limmazk.restaurante_api.model.Dish;
import br.com.limmazk.restaurante_api.model.Order;
import br.com.limmazk.restaurante_api.model.OrderItem;
import br.com.limmazk.restaurante_api.repository.ClientRepository;
import br.com.limmazk.restaurante_api.repository.DishRepository;
import br.com.limmazk.restaurante_api.repository.OrderRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ClientRepository clientRepository;
    private final DishRepository dishRepository;

    public OrderService(OrderRepository orderRepository,
                        ClientRepository clientRepository,
                        DishRepository dishRepository) {

        this.orderRepository = orderRepository;
        this.clientRepository = clientRepository;
        this.dishRepository = dishRepository;
    }

    @Transactional
    public OrderResponseDTO create(OrderRequestDTO dto) {

        Client client = clientRepository.findById(dto.clientId())
                .orElseThrow(() -> new ResourceNotFoundException("Client not found."));

        Order order = new Order();
        order.setClient(client);
        order.setStatus(OrderStatus.PENDING);
        order.setCreatedAt(LocalDateTime.now());

        List<OrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (OrderItemRequestDTO itemDTO : dto.items()) {

            Dish dish = dishRepository.findById(itemDTO.dishId())
                    .orElseThrow(() -> new ResourceNotFoundException("Dish not found."));

            if (!dish.getAvailable()) {
                throw new RuntimeException("Dish unavailable.");
            }

            OrderItem orderItem = new OrderItem();
            orderItem.setOrder(order);
            orderItem.setDish(dish);
            orderItem.setQuantity(itemDTO.quantity());
            orderItem.setUnitPrice(dish.getPrice());

            BigDecimal subtotal = dish.getPrice()
                    .multiply(BigDecimal.valueOf(itemDTO.quantity()));

            total = total.add(subtotal);

            orderItems.add(orderItem);
        }

        order.setItems(orderItems);
        order.setTotalPrice(total);

        Order orderSaved = orderRepository.save(order);

        return OrderMapper.toResponseDTO(orderSaved);
    }
}
