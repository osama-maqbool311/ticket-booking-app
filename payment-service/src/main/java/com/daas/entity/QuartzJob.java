package com.daas.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.Instant;

@Entity
@Table(name="quartz_job")
public class QuartzJob extends PanacheEntity {
    public Instant createdAt;

    public QuartzJob() {
        createdAt = Instant.now();
    }

    public QuartzJob(Instant time) {
        this.createdAt = time;
    }
}