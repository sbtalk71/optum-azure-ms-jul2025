package com.demo.spring.kafka;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*@Data
@NoArgsConstructor
@AllArgsConstructor*/
public class ProductStockUpdatedEvent extends Event {
    private int quantity;
    
    public ProductStockUpdatedEvent(String productId, int quantity) {
    	super(productId);
    	this.quantity=quantity;
    }
    
    public ProductStockUpdatedEvent() {
		// TODO Auto-generated constructor stub
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
    
}
