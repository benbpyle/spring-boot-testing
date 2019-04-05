package com.binaryheap.testing.repositories;

import com.binaryheap.testing.models.Bag;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BagRepository extends JpaRepository<Bag, Long> {
}
