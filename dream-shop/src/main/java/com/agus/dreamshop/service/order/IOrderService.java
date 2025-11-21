package com.agus.dreamshop.service.order;

import com.agus.dreamshop.dto.OrderDto;
import com.agus.dreamshop.model.Order;

import java.util.List;

public interface IOrderService {
    Order placeOrder(Long userId);
    OrderDto getOrder(Long orderId);
    List<OrderDto> getUserOrders(Long userId);
}