package com.example.GestionDePointage.Services;


import com.example.GestionDePointage.Repositories.EmployeRepo;
import com.example.GestionDePointage.entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletContext;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeService {

    @Autowired
    EmployeRepo EmployeRepo ;


    public List<Employe> getallEmployes(){
        return EmployeRepo.findAll();
    }

    public Employe getEmployeById(int id) {
        return EmployeRepo.findById(id).orElse(null);
    }

    public Employe getEmployeByIdCard(int idCard) {
        return EmployeRepo.findEmployeByIdCard(idCard);
    }

    public Employe saveEmploye(Employe employe) {
        return EmployeRepo.save(employe);
    }

    public Employe updateEmploye(Employe e ) {
        Optional<Employe> optionalInfo = EmployeRepo.findById(e.getIdEmploye());
        Employe existingEmploye = null;
        if (optionalInfo.isPresent()) {
            existingEmploye = optionalInfo.get();
            existingEmploye.setNomEmploye(e.getNomEmploye());
              existingEmploye.setIdCard(e.getIdCard());
            return EmployeRepo.save(existingEmploye);
        } else {
            // handle error here
        }
        return existingEmploye;
    }

    public void deleteEmploye(int id) {
        EmployeRepo.deleteById(id);
    }


}
