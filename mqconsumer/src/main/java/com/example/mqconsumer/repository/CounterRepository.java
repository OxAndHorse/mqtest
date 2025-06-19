package com.example.mqconsumer.repository;

import com.example.mqconsumer.entity.CounterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CounterRepository extends JpaRepository<CounterEntity, Integer> {}
