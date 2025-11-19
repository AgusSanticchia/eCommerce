package com.agus.dreamshop.service.cartItem;

import com.agus.dreamshop.model.CartItem;

public interface ICartItemService {
    void addItemToCart(Long cartId, Long productId, int stock);
    void removeItemFromCart(Long cartId, Long productId);
    void updateItemStock(Long cartId, Long productId, int stock);

    CartItem getCartItem(Long cartId, Long productId);
}
