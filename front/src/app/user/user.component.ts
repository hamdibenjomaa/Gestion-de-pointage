import { Component, OnInit } from '@angular/core';
import {EmployeService} from "../services/employe.service";
import {Employe} from "../models/employe";
import {Router} from "@angular/router";

@Component({
    selector: 'app-user',
    templateUrl: './user.component.html',
    styleUrls: ['./user.component.css']
})
export class UserComponent implements OnInit {

employees : Employe[]

    constructor( private employeService : EmployeService , private router: Router) { }

    ngOnInit() {
    this.getAllEmploye()
    }

    getAllEmploye(){
    this.employeService.GetAllEmploye().subscribe(res => {this.employees = res
   console.log("hay elista",this.employees) } ) ;
    }
    DeleteEmploye(e : Employe){
    this.employeService.deleteEmploye(e.idEmploye).subscribe(res => {console.log(res);this.getAllEmploye() ;
    })}

}
