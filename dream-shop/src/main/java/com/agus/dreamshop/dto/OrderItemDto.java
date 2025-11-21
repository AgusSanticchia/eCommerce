package com.agus.dreamshop.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemDto {
    private Long productId;
    private String productName;
    private int stock;
    private BigDecimal price;
}
