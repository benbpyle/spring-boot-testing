package com.binaryheap.testing.mappers;

import com.binaryheap.testing.dtos.BagDto;
import com.binaryheap.testing.models.Bag;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@ContextConfiguration(classes =
        BagMapperTests.BagMapperSpringTestConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class BagMapperTests {

    @Configuration
    @ComponentScan(basePackageClasses = { BagMapperTests.class, BagMapper.class })
    public static class BagMapperSpringTestConfig { }

    @Autowired
    private BagMapper bagMapper;

    @Test
    public void map_bag_dto_from_bag() {
        // arrange
        Bag bag = new Bag();
        bag.setId(1L);
        bag.setName("My Bag");

        // act
        BagDto dto = bagMapper.mapBagDtoFromBag(bag);

        // assert
        assertEquals(bag.getId(), dto.getId());
        assertEquals(bag.getName(), dto.getName());
    }
}
