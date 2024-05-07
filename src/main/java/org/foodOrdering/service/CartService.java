package org.foodOrdering.service;

import org.foodOrdering.Exception.CartException;
import org.foodOrdering.Exception.CartItemException;
import org.foodOrdering.Exception.FoodException;
import org.foodOrdering.Exception.UserException;
import org.foodOrdering.model.Cart;
import org.foodOrdering.model.CartItem;
import org.foodOrdering.request.AddCartItemRequest;

public interface CartService {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
