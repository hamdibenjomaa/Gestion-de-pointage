package com.example.GestionDePointage.Repositories;

import com.example.GestionDePointage.entities.Employe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeRepo extends JpaRepository<Employe,Integer> {
    Employe findEmployeByIdCard(int idCard);
    

}
