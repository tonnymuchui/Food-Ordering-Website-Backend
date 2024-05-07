package org.foodOrdering.controller;

import org.foodOrdering.Exception.CartException;
import org.foodOrdering.Exception.CartItemException;
import org.foodOrdering.Exception.FoodException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Cart;
import org.foodOrdering.model.CartItem;
import org.foodOrdering.model.User;
import org.foodOrdering.request.AddCartItemRequest;
import org.foodOrdering.request.UpdateCartItemRequest;
import org.foodOrdering.service.CartService;
import org.foodOrdering.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CartController {

    private final CartService cartService;
    private final UserService userService;

    @Autowired
    public CartController(CartService cartService, UserService userService) {
        this.cartService = cartService;
        this.userService = userService;
    }

    @PutMapping("/cart/add")
    public ResponseEntity<CartItem> addItemToCart(@RequestBody AddCartItemRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws UserException, FoodException, CartException, CartItemException {
        CartItem cart = cartService.addItemToCart(req, jwt);
        return ResponseEntity.ok(cart);

    }

    @PutMapping("/cart-item/update")
    public ResponseEntity<CartItem> updateCartItemQuantity(
            @RequestBody UpdateCartItemRequest req,
            @RequestHeader("Authorization") String jwt) throws CartItemException {
        CartItem cart = cartService.updateCartItemQuantity(req.getCartItemId(), req.getQuantity());
        return ResponseEntity.ok(cart);
    }

    @DeleteMapping("/cart-item/{id}/remove")
    public ResponseEntity<Cart> removeItemFromCart(@PathVariable Long id,
                                                   @RequestHeader("Authorization") String jwt) throws UserException, CartException, CartItemException {

        Cart cart = cartService.removeItemFromCart(id, jwt);
        return ResponseEntity.ok(cart);

    }

    @GetMapping("/cart/total")
    public ResponseEntity<Double> calculateCartTotals(@RequestParam Long cartId,
                                                      @RequestHeader("Authorization") String jwt) throws UserException, CartException {


        User user = userService.findUserProfileByJwt(jwt);

        Cart cart = cartService.findCartByUserId(user.getId());
        double total = cartService.calculateCartTotals(cart);
        return ResponseEntity.ok(total);
    }

    @GetMapping("/cart/")
    public ResponseEntity<Cart> findUserCart(
            @RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.findCartByUserId(user.getId());
        return ResponseEntity.ok(cart);
    }

    @PutMapping("/cart/clear")
    public ResponseEntity<Cart> clearCart(
            @RequestHeader("Authorization") String jwt) throws UserException, CartException {
        User user = userService.findUserProfileByJwt(jwt);
        Cart cart = cartService.clearCart(user.getId());
        return ResponseEntity.ok(cart);
    }

}
