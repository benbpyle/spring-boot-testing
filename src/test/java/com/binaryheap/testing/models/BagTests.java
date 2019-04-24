package com.binaryheap.testing.models;

import com.binaryheap.testing.exceptions.ClubExistsException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BagTests {
    @Test
    public void add_club_should_add_one_club() throws ClubExistsException {
        // arrange
        Club club = new Club();
        Bag bag = new Bag();
        club.setNumber(7);
        club.setLoft(34.5F);

        // act
        bag.addClub(club);

        // assert
        assertEquals(1, bag.getClubs().size());
    }


    @Test(expected = ClubExistsException.class)
    public void add_club_should_throw_exists_exception() throws ClubExistsException {
        // arrange
        Club club1 = new Club();
        Club club2 = new Club();
        Bag bag = new Bag();
        club1.setNumber(7);
        club1.setLoft(34.5F);
        club2.setNumber(7);
        club2.setLoft(34.5F);

        // act
        bag.addClub(club1);
        bag.addClub(club2);

        // assert will be that there is an exception defined above
    }

    @Test
    public void add_club_should_create_integration_event() throws ClubExistsException {
        // arrange
        Club club = new Club();
        Bag bag = new Bag();
        club.setNumber(7);
        club.setLoft(34.5F);

        // act
        bag.addClub(club);

        // assert
        assertEquals(1, bag.getIntegrationEvents().size());
    }

    @Test
    public void sonar_test() {
        Bag bag = new Bag();
        bag.setId(1L);

        assertEquals(1L, bag.getId());
    }
}
