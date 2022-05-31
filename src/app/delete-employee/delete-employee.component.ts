import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../employee';
import { EmployeeService } from '../employee/employee.service';

@Component({
  selector: 'app-delete-employee',
  templateUrl: './delete-employee.component.html',
  styleUrls: ['./delete-employee.component.css']
})
export class DeleteEmployeeComponent implements OnInit {
  employee:Employee;
  constructor(private empService:EmployeeService,private route:ActivatedRoute,private router:Router) { }

  ngOnInit(): void {
    let id:number=this.route.snapshot.params['id'];
    console.log(this.route.snapshot);
    this.empService.getEmployessById(id).subscribe(data=>this.employee=data);
  }
  onDelete(){
    this.empService.deleteEmployee(this.employee.id).subscribe(data =>{
      this.router.navigate(["/employees"]);
    });
  }

  onCancel(){
    this.router.navigate(["/employees"]);
  }
}
