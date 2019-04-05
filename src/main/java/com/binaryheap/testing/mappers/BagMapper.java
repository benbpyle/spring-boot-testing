package com.binaryheap.testing.mappers;

import com.binaryheap.testing.dtos.BagCreateDto;
import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.models.Bag;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BagMapper {
    BagDto mapBagDtoFromBag(Bag source);
    Bag mapBagFromBagCreateDto(BagCreateDto source);
    Bag mapBagFromBagDto(BagDto source);
}
