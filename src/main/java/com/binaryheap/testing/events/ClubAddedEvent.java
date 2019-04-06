package com.binaryheap.testing.events;

import com.binaryheap.testing.models.Club;

public class ClubAddedEvent implements EventDetail {
    private long id;
    private long bagId;
    private float loft;
    private int number;

    public static ClubAddedEvent from(Club club) {
        ClubAddedEvent addedEvent = new ClubAddedEvent();
        addedEvent.setId(club.getId());
        addedEvent.setNumber(club.getNumber());
        addedEvent.setLoft(club.getLoft());
        if (club.getBag() != null) {
            addedEvent.setBagId(club.getBag().getId());
        }

        return addedEvent;
    }

    public long getId() {
        return id;
    }

    public float getLoft() {
        return loft;
    }

    public void setLoft(float loft) {
        this.loft = loft;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getBagId() {
        return bagId;
    }

    public void setBagId(long bagId) {
        this.bagId = bagId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

}
