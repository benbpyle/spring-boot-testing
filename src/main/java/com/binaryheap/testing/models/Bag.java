package com.binaryheap.testing.models;

import com.binaryheap.testing.events.ClubAddedEvent;
import com.binaryheap.testing.events.IntegrationEvent;
import com.binaryheap.testing.exceptions.ClubExistsException;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Entity
@Table(name = "bags")
@SequenceGenerator(name = "bag_id_seq", allocationSize = 1)
public class Bag extends GolfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bag_id_seq")
    private long id;

    private String name;

    @OneToMany(mappedBy = "bag", cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Club> clubs = new HashSet<>();

    // region Getters/Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Set<Club> getClubs() {
        return clubs;
    }

    public void setClubs(Set<Club> clubs) {
        this.clubs = clubs;
    }
    // endregion

    public void addClub(Club club) throws ClubExistsException {
        Optional<Club> searchedClub = clubs.stream().filter(x -> x.getNumber() == club.getNumber()).findFirst();
        if (searchedClub.isPresent()) {
            throw new ClubExistsException("Club " + club.getId() + " already exists");
        }

        club.setBag(this);
        clubs.add(club);

        IntegrationEvent event = new IntegrationEvent();
        event.setDetail(ClubAddedEvent.from(club));
        addIntegrationEvent(event);
    }
}
