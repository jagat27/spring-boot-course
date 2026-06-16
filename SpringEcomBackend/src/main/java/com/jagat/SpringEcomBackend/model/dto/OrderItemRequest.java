package com.jagat.SpringEcomBackend.model.dto;

public record OrderItemRequest(
        int productId,
        int quantity
) {
}
