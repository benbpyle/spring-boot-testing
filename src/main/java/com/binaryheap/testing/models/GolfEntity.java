package com.binaryheap.testing.models;

import com.binaryheap.testing.events.IntegrationEvent;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class GolfEntity {
    private List<IntegrationEvent> integrationEvents = new ArrayList<>();

    @Column(name = "created_datetime")
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_datetime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;

    public void addIntegrationEvent(IntegrationEvent event) {
        integrationEvents.add(event);
    }

    public void setCreateDateTime(LocalDateTime createDateTime) {
        this.createDateTime = createDateTime;
    }

    public void setUpdateDateTime(LocalDateTime updateDateTime) {
        this.updateDateTime = updateDateTime;
    }

    public List<IntegrationEvent> getIntegrationEvents() {
        return integrationEvents;
    }

    public LocalDateTime getCreateDateTime() {
        return createDateTime;
    }

    public LocalDateTime getUpdateDateTime() {
        return updateDateTime;
    }


}


