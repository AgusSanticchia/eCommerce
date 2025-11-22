package com.agus.dreamshop.controller;

import com.agus.dreamshop.exception.ResourceNotFoundException;
import com.agus.dreamshop.model.Cart;
import com.agus.dreamshop.model.User;
import com.agus.dreamshop.response.ApiResponse;
import com.agus.dreamshop.service.cart.ICartService;
import com.agus.dreamshop.service.cartItem.CartItemService;
import com.agus.dreamshop.service.cartItem.ICartItemService;
import com.agus.dreamshop.service.user.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/cartItems")
public class CartItemController {
    private final ICartItemService cartItemService;
    private final ICartService cartService;
    private final IUserService userService;

    @PostMapping("/item/add")
    public ResponseEntity<ApiResponse> addItemToCart( @RequestParam Long productId, @RequestParam Integer stock) {
        try {
            User user = userService.getUserById(Long.valueOf(1L));
            Cart cart = cartService.initializeNewCart(user);

            cartItemService.addItemToCart(cart.getId(), productId, stock);
            return ResponseEntity.ok(new ApiResponse("Item added to cart successfully", null));
        } catch (ResourceNotFoundException e){
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @DeleteMapping("/cart/{cartId}/item/{itemId}/remove")
    public ResponseEntity<ApiResponse> removeItemFromCart(@PathVariable Long cartId, @PathVariable Long itemId) {
        try {
            cartItemService.removeItemFromCart(cartId, itemId);
            return ResponseEntity.ok(new ApiResponse("Remove Item Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }

    @PutMapping("/cart/{cartId}/item/{itemId}/update")
    public ResponseEntity<ApiResponse> updateItemStock(@PathVariable Long cartId, @PathVariable Long itemId, @RequestParam Integer stock) {
        try {
            cartItemService.updateItemStock(cartId, itemId, stock);
            return ResponseEntity.ok(new ApiResponse("Update Item Stock Success", null));
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(NOT_FOUND).body(new ApiResponse(e.getMessage(), null));
        }
    }
}
