import { Component, OnInit } from '@angular/core';
import {AuthService} from "../shared/auth.service";
import {FormControl, FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {


  LoginForm = new FormGroup({
    email: new FormControl(''),
    password: new FormControl('')


  });

  constructor(private router: Router) { }

  ngOnInit(): void {
  }


  get f() { return this.LoginForm.controls; }submit(){
    // @ts-ignore
    if (this.f.email.value== "admin" && this.f.password.value== "admin"){
      this.router.navigateByUrl('dashboard');
    }else{
      this.router.navigateByUrl('/login');
      alert("verifier votre email ou mot de passe")
    }
  }
}