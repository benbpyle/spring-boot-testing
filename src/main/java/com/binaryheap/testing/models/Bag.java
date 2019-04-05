package com.binaryheap.testing.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "bags")
@SequenceGenerator(name = "bag_id_seq", allocationSize = 1)
public class Bag {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bag_id_seq")
    private long id;

    @OneToMany(mappedBy = "bag", cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    private Set<Club> clubs = new HashSet<>();

    // region Getters/Setters
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
}
