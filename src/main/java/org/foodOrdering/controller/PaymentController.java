package org.foodOrdering.controller;

import com.stripe.exception.StripeException;
import org.foodOrdering.Exception.OrderException;
import org.foodOrdering.model.Order;
import org.foodOrdering.model.PaymentResponse;
import org.foodOrdering.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PaymentController {

	private final PaymentService paymentService;

	@Autowired
	public PaymentController(PaymentService paymentService) {
		this.paymentService = paymentService;
	}
	
	@PostMapping("/{orderId}/payment")
	public ResponseEntity<PaymentResponse> generatePaymentLink(@PathVariable Order orderId)
			throws StripeException, OrderException {

		PaymentResponse res = paymentService.generatePaymentLink(orderId);

		return new ResponseEntity<PaymentResponse>(res, HttpStatus.ACCEPTED);
	}

}
