package com.jsp.ai.repository;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jsp.ai.entity.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, BigInteger> {
	
	@Modifying
	@Transactional
	@Query("UPDATE OrderEntity o SET o.orderStatus = 'cancelled' WHERE o.orderId = orderId")
	void updateOrderStatus(BigInteger orderId);
}
