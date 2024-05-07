package org.foodOrdering.service;

import com.stripe.exception.StripeException;
import org.foodOrdering.Exception.OrderException;
import org.foodOrdering.model.Order;
import org.foodOrdering.model.PaymentResponse;

public interface PaymentService {
	
	public PaymentResponse generatePaymentLink(Order order) throws OrderException, StripeException;

}
