package com.binaryheap.testing.services;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.mappers.BagMapper;
import com.binaryheap.testing.models.Bag;
import com.binaryheap.testing.repositories.BagRepository;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class BagServiceImplTests {
    @Test
    public void get_bags_should_return_one() {
        // arrange
        BagRepository repository = Mockito.mock(BagRepository.class);
        BagMapper bagMapper = Mockito.mock(BagMapper.class);
        Pageable p = PageRequest.of(0, 20);
        Bag bag = new Bag();
        bag.setId(1L);
        bag.setName("My Bag");
        List<Bag> bags = Arrays.asList(bag);
        Page<Bag> pagesOfBag = new PageImpl<>(bags);

        when(repository.findAll(p)).thenReturn(pagesOfBag);
        when(bagMapper.mapBagDtoFromBag(any())).thenReturn(new BagDto());

        BagServiceImpl service = new BagServiceImpl(repository, bagMapper);

        // act
        Page<BagDto> bagDtos = service.getBags(p);

        // assert
        assertEquals(1, bagDtos.getContent().size());
    }
}
