import { Routes } from '@angular/router';

import { HomeComponent } from '../../home/home.component';
import { UserComponent } from '../../user/user.component';
import { AddUserComponent } from '../../add-user/add-user.component';
import {UpdateUserComponent} from "../../update-user/update-user.component";


export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard',      component: HomeComponent },
    { path: 'user',           component: UserComponent },
    { path: 'add',        component: AddUserComponent },
    { path: 'update/:id',        component: UpdateUserComponent },


];
