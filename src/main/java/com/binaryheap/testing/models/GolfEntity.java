package com.binaryheap.testing.models;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

public class GolfEntity {
    @Column(name = "created_datetime")
    @CreationTimestamp
    private LocalDateTime createDateTime;

    @Column(name = "updated_datetime")
    @UpdateTimestamp
    private LocalDateTime updateDateTime;
}
