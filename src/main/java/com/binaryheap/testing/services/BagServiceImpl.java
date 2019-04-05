package com.binaryheap.testing.services;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.mappers.BagMapper;
import com.binaryheap.testing.repositories.BagRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BagServiceImpl implements BagService {
    private final BagRepository bagRepository;
    private final BagMapper bagMapper;

    private BagServiceImpl(BagRepository bagRepository, BagMapper bagMapper) {
        this.bagRepository = bagRepository;
        this.bagMapper = bagMapper;
    }

    @Override
    public Page<BagDto> getBags(Pageable pageable) {
        return bagRepository.findAll(pageable).map(bagMapper::mapBagDtoFromBag);
    }
}
