import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Employe} from "../models/employe";
import {FormControl, ɵFormGroupValue, ɵTypedOrUntyped} from "@angular/forms";

@Injectable({
    providedIn: 'root'
})
export class EmployeService {

    api = 'http://localhost:8081'

    constructor(private httpclient: HttpClient) {
    }

    GetAllEmploye(): Observable<any> {
        return this.httpclient.get<any>(`${this.api}/AllEmployees`);
    }

    addEmploye(employe: ɵTypedOrUntyped<{ idCard: FormControl<string | null>; nomEmploye: FormControl<string | null> }, ɵFormGroupValue<{ idCard: FormControl<string | null>; nomEmploye: FormControl<string | null> }>, any>) {
        return this.httpclient.post<Employe>(`${this.api}/AddEmploye`, employe);
    }

    GetEmployeById(id: any): Observable<any> {
        return this.httpclient.get<any>(`${this.api}/getEmployeById/${id}`);
    }

    modifyEmploye( Employe: any) {
        // @ts-ignore
        return this.httpclient.put<employe>(`${this.api}/modify-Employe`, Employe)
    }


    deleteEmploye(id: any): Observable<any> {
        return this.httpclient.delete(`${this.api}/deleteEmploye/${id}`);
    }


}
