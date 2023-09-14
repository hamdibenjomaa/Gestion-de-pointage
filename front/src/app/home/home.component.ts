import { Component, OnInit } from '@angular/core';
import {Pointages} from "../models/pointages";
import {Router} from "@angular/router";
import {PointagesService} from "../services/pointages.service";

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

    pointages : Pointages[]
  constructor(private pointageService : PointagesService , private router: Router) { }

  ngOnInit() {
      this.getAllPointages()
    }
    getAllPointages(){
        this.pointageService.GetAllPointages().subscribe(res => {this.pointages = res
            console.log("hay elista pointage",this.pointages) } ) ;
    }

}
