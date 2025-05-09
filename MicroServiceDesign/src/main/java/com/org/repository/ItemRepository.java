package com.org.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.org.model.Item;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    // You can add custom query methods here if needed
}