package org.turjoysaha.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.turjoysaha.ecom.model.Price;

import java.util.UUID;

public interface PriceRepository extends JpaRepository<Price, UUID> {
}