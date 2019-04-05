package com.binaryheap.testing.controllers;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.services.BagService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bags")
public class BagController {
    private final BagService bagService;

    public BagController(BagService bagService) {
        this.bagService = bagService;
    }

    @GetMapping
    public ResponseEntity<Page<BagDto>> getBags(Pageable pageable) {
        return ResponseEntity.ok(bagService.getBags(pageable));
    }
}
