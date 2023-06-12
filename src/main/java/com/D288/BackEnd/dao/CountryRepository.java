package com.D288.BackEnd.dao;

import com.D288.BackEnd.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
