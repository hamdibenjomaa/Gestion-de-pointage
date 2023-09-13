import { Component, OnInit } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {Employe} from "../models/employe";
import {FormControl, FormGroup} from "@angular/forms";
import {EmployeService} from "../services/employe.service";

@Component({
  selector: 'app-update-user',
  templateUrl: './update-user.component.html',
  styleUrls: ['./update-user.component.scss']
})
export class UpdateUserComponent implements OnInit {
  employe : Employe
  id : any
  EmployeForm = new FormGroup({
    nomEmploye: new FormControl(''),
    idCard: new FormControl(''),
  });
  constructor(private router: Router, private router1: ActivatedRoute ,private employeService : EmployeService) { }

  ngOnInit(): void {
    this.router1.paramMap.subscribe(paramMap => {
      this.id = paramMap.get('id');
      this.employeService.GetEmployeById(this.id).subscribe(res => {this.employe = res;
        console.log('empbyid' , res)})
    })

  }
  updateEmploye() {
      this.employeService.modifyEmploye( this.employe)
          .subscribe(data => {
            console.log("update employee " , data);
            this.employe = data;
            // this.gotoList();
          }, error => console.log(error));
    this.router.navigateByUrl('/user')

    }



  submit(f) {
    this.updateEmploye();
  }

}
