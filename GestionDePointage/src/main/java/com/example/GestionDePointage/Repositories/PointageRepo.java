package com.example.GestionDePointage.Repositories;

import com.example.GestionDePointage.entities.pointage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointageRepo extends JpaRepository<pointage,Integer> {
}
