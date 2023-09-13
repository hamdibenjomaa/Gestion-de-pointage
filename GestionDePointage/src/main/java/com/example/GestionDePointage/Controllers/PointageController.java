package com.example.GestionDePointage.Controllers;


import com.example.GestionDePointage.Repositories.PointageRepo;
import com.example.GestionDePointage.Services.EmployeService;
import com.example.GestionDePointage.Services.PointageService;
import com.example.GestionDePointage.entities.pointage;
import com.example.GestionDePointage.Controllers.EmployeController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class PointageController {

    @Autowired
    PointageService PointageSer ;
    @Autowired
    EmployeService ec ;

    @GetMapping({"/AllPointages"})
    public List<pointage> GetAllv(){
        return PointageSer.getallpointages();
    }

    @PostMapping("/AddPointage/{idc}")
    @ResponseBody
    public pointage savePointage(@PathVariable("idc") int idc ,@RequestBody pointage Pointage) {
        if (ec.getEmployeByIdCard(idc) != null){
            return PointageSer.savepointage(Pointage);
        }
        else{
            return null ;
        }
    }



    @GetMapping("/getPointageById/{id}")
    @ResponseBody
    public pointage getPointageById(@PathVariable("id") int id ){
        return PointageSer.getpointageById(id) ;
    }

    @DeleteMapping("/deletePointage/{id}")
    @ResponseBody
    public void deletePointage(@PathVariable("id")  int id) {
        PointageSer.deletepointage(id);
    }
}
