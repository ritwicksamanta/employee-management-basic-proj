import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddEmployeeComponent } from './add-employee/add-employee.component';
import { DeleteEmployeeComponent } from './delete-employee/delete-employee.component';
import { EmployeeComponentComponent } from './employee-component/employee-component.component';
import { UpdateEmployeeComponent } from './update-employee/update-employee.component';

const routes: Routes = [
  {
    path:"",
    redirectTo:"employees",
    pathMatch:"full"
  },
  {
    path:"employees",
    component:EmployeeComponentComponent
  },
  {
    path:"add",
    component:AddEmployeeComponent
  },
  {
    path:"delete/:id",
    component:DeleteEmployeeComponent
  },
  {
    path:"update/:id",
    component:UpdateEmployeeComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
