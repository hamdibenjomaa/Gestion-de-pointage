package com.example.GestionDePointage.Controllers;



import com.example.GestionDePointage.Services.EmployeService;
import com.example.GestionDePointage.entities.Employe;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@CrossOrigin("http://localhost:4200")
public class EmployeController {

    @Autowired
    EmployeService EmployeSer ;


    @GetMapping({"/AllEmployees"})
    public List<Employe> GetAllv(){
        return EmployeSer.getallEmployes();
    }

    @PostMapping("/AddEmploye")
    @ResponseBody
    public Employe saveEmploye(@RequestBody Employe employe) {
        return EmployeSer.saveEmploye(employe);
    }

    @GetMapping("/getEmployeById/{id}")
    @ResponseBody
    public Employe getEmployeById(@PathVariable("id") int id ){
        return EmployeSer.getEmployeById(id) ;
    }

    @GetMapping("/getEmployeByIdCard/{idc}")
    @ResponseBody
    public Employe getEmployeByIdCard(@PathVariable("idc") int idCard ){
        return EmployeSer.getEmployeByIdCard(idCard);
    }


    @PutMapping("/modify-Employe")
    public ResponseEntity<Employe> modifyEmploye(@RequestBody Employe employe  ){
        Employe updatedEmploye = EmployeSer.updateEmploye(employe) ;
        return ResponseEntity.ok(updatedEmploye);
    }

    @DeleteMapping("/deleteEmploye/{id}")
    @ResponseBody
    public void deleteEmploye(@PathVariable("id")  int id) {
        EmployeSer.deleteEmploye(id);
    }
}
