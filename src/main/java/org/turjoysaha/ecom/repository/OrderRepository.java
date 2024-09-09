package org.turjoysaha.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turjoysaha.ecom.model.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}