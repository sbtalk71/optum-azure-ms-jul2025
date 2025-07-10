package com.demo.spring.kafka;

import java.time.Instant;

import lombok.Data;

//@Data
public abstract class Event {
    private String productId;
    private Instant timestamp;
    
    public Event() {
		// TODO Auto-generated constructor stub
	}
    public Event(String productId) {
		this.productId=productId;
	}
    
    public Event(Instant timestamp) {
		this.timestamp=timestamp;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Instant getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}
    
}

