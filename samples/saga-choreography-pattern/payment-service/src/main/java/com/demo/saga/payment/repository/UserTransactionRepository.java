package com.demo.saga.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.saga.payment.entity.UserTransaction;

public interface UserTransactionRepository extends JpaRepository<UserTransaction,Integer> {
}
