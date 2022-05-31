import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-employee-component',
  templateUrl: './employee-component.component.html',
  styleUrls: ['./employee-component.component.css']
})
export class EmployeeComponentComponent implements OnInit {
  employees:Employee[];
  constructor(private empService:EmployeeService, private router:Router) { }

  ngOnInit(): void {
    this.loadData();
  }
  loadData() {
    this.empService.getEmployess().subscribe((data:Employee[])=>{
      console.log(data);
      this.employees=data;
    });
  }

 

  onClickAdd(){
    this.router.navigate(['/add']);
  }
}
