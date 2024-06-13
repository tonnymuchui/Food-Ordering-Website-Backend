package com.food_ordering.service;

import com.food_ordering.Exception.CartException;
import com.food_ordering.Exception.CartItemException;
import com.food_ordering.Exception.FoodException;
import com.food_ordering.Exception.UserException;
import com.food_ordering.model.Cart;
import com.food_ordering.model.CartItem;
import com.food_ordering.request.AddCartItemRequest;

public interface CartSerive {

	public CartItem addItemToCart(AddCartItemRequest req, String jwt) throws UserException, FoodException, CartException, CartItemException;

	public CartItem updateCartItemQuantity(Long cartItemId,int quantity) throws CartItemException;

	public Cart removeItemFromCart(Long cartItemId, String jwt) throws UserException, CartException, CartItemException;

	public Long calculateCartTotals(Cart cart) throws UserException;
	
	public Cart findCartById(Long id) throws CartException;
	
	public Cart findCartByUserId(Long userId) throws CartException, UserException;
	
	public Cart clearCart(Long userId) throws CartException, UserException;
	

	

}
