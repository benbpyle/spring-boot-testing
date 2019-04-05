package com.binaryheap.testing.models;

import io.micrometer.core.lang.NonNull;

import javax.persistence.*;

@Entity
@Table(name = "clubs")
@SequenceGenerator(name = "club_id_seq", allocationSize = 1)
public class Club extends GolfEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "club_id_seq")
    private long id;

    @NonNull
    private String brand;

    @NonNull
    private float loft;

    @NonNull
    private int number;

    @ManyToOne
    @JoinColumn(name = "bag_id", nullable = false)
    private Bag bag;

    // region getters and setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public float getLoft() {
        return loft;
    }

    public void setLoft(float loft) {
        this.loft = loft;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Bag getBag() {
        return bag;
    }

    public void setBag(Bag bag) {
        this.bag = bag;
    }
    // endregion
}
