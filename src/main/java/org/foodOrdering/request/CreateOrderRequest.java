package org.foodOrdering.request;

import lombok.Data;
import org.foodOrdering.model.Address;

@Data
public class CreateOrderRequest {
 
	private Long restaurantId;
	
	private Address deliveryAddress;
	
    
}
