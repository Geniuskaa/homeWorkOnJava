package com.example.hw8.repositories;

import com.example.hw8.models.Cache;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CalculatorRepository extends JpaRepository<Cache, Long> {
    @Query("SELECT c FROM Cache c WHERE c.a = ?1 and c.operator = ?2 and c.b = ?3")
    Cache findByAAndOperatorAndB(String a, String operator, String b);

}
