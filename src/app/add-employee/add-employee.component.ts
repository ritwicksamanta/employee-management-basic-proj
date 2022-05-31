import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-add-employee',
  templateUrl: './add-employee.component.html',
  styleUrls: ['./add-employee.component.css']
})
export class AddEmployeeComponent implements OnInit {

  constructor( private empService:EmployeeService, private router:Router) { }

  ngOnInit(): void {
  }
  onSubmit(employee:Employee){
    this.empService.addEmployee(employee).subscribe(data => {
      this.router.navigate(["/employees"]);
    });
  }
  onCancel(){
    this.router.navigate(["/employees"]);
  }
}
