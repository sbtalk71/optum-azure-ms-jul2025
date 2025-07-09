package com.demo.saga.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.saga.order.entity.PurchaseOrder;

public interface OrderRepository extends JpaRepository<PurchaseOrder,Integer> {
}
