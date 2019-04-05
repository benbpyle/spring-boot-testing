package com.binaryheap.testing.services;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.models.Bag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BagService {
    Page<BagDto> getBags(Pageable pageable);
}
