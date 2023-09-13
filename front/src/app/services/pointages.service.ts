import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pointages} from "../models/pointages";

@Injectable({
  providedIn: 'root'
})
export class PointagesService {

  api = 'http://localhost:8081'
  constructor(private  httpclient: HttpClient) { }

  GetAllPointages(): Observable<any> {
    return this.httpclient.get<any>(`${this.api}/AllPointages`);
  }

  addPointages(formData: FormData) {
    return this.httpclient.post<Pointages>(`${this.api}/AddPointages`, formData);
  }

}
