package com.D288.BackEnd.dao;

import com.D288.BackEnd.entities.Vacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacationRepository extends JpaRepository<Vacation, Long> {
}