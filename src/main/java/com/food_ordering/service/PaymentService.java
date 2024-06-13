package com.food_ordering.service;

import com.stripe.exception.StripeException;
import com.food_ordering.model.Order;
import com.food_ordering.model.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws StripeException;

}
