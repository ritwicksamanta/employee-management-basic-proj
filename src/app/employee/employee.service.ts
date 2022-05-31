import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../employee';
/**
 * This service class will make rest calls
 */
@Injectable({
  providedIn: 'root'
})
export class EmployeeService {
  getEmployessById(id: number):Observable<Employee> {
    return this.http.get<Employee>(`${this.baseUrl}${id}`);
  }
  
  constructor(private http:HttpClient) { }
  
  private  baseUrl:string="http://localhost:8081/api/employees/";
  
  /**
   * get all the employees
   * it will return a Observable so that we can subscribe to that
   */
  
  getEmployess():Observable<Employee[]>{
    return this.http.get<Employee[]>(`${this.baseUrl}`);
  }
  deleteEmployee(id: number):Observable<any> {
    return this.http.delete(`${this.baseUrl}${id}`);
  }
  
  addEmployee(employee: Employee):Observable<any> {
    return this.http.post(this.baseUrl,employee);
  }
  updateEmployee(id: number, employee: Employee):Observable<any> {
    return this.http.put(`${this.baseUrl}${id}`,employee);
  }
}
