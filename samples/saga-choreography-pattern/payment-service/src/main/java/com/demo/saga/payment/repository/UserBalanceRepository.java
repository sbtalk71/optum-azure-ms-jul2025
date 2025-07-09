package com.demo.saga.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.saga.payment.entity.UserBalance;

public interface UserBalanceRepository extends JpaRepository<UserBalance,Integer> {
}
