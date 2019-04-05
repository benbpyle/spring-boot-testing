package com.binaryheap.testing.repositories;

import com.binaryheap.testing.models.Bag;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class BagRepositoryTests {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private BagRepository bagRepository;

    @Test
    public void find_bags_returns_one_item() {
        // arrange
        Bag bag = new Bag();
        bag.setName("My Bag");
        entityManager.persist(bag);
        entityManager.flush();
        Pageable p = PageRequest.of(0, 20);
        // act
        Page<Bag> bags = bagRepository.findAll(p);
        // assert
        Assert.assertEquals(1, bags.getContent().size());
    }
}
