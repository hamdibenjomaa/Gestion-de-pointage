import { Component, OnInit } from '@angular/core';
import {EmployeService} from "../services/employe.service";
import {Router} from "@angular/router";
import {Employe} from "../models/employe";
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {
  employe : Employe
  EmployeForm = new FormGroup({
    nomEmploye: new FormControl(''),
    idCard: new FormControl(''),
  });

  constructor( private employeService : EmployeService , private router: Router) { }

  ngOnInit(): void {
  }


  submit() {
    if (this.EmployeForm.valid) {
      this.employeService.addEmploye(this.EmployeForm.value).subscribe((res => {
        this.router.navigateByUrl('/user')
      }));


    }
  }
}
