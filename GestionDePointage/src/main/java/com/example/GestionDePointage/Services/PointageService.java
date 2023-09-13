package com.example.GestionDePointage.Services;


import com.example.GestionDePointage.Repositories.PointageRepo;
import com.example.GestionDePointage.entities.pointage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class PointageService {

    @Autowired
    PointageRepo PointageRepo ;


    public List<pointage> getallpointages(){
        return PointageRepo.findAll();
    }

    public pointage getpointageById(int id) {
        return PointageRepo.findById(id).orElse(null) ;
    }

    public pointage savepointage(pointage p) {
        return PointageRepo.save(p);
    }

    public void deletepointage(int id) {
        PointageRepo.deleteById(id);
    }
}
