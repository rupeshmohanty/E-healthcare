package com.example.Ehealthcare.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.Ehealthcare.entity.Diseases;

@Repository
public interface DiseasesDao extends JpaRepository<Diseases,Long>{
    @Query(value = "SELECT e FROM Diseases e WHERE e.name = ?1")
    Diseases getData(String name);
}
