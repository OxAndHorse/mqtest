package com.example.mqconsumer.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "counter")
@Data
public class CounterEntity {
    @Id
    private Integer id;

    @Column(name = "total_count")
    private Long totalCount;

    // Getters & Setters
}
