import {Injectable} from '@angular/core';
import {Student} from "../model/student";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {StudentComponent} from "../student/student.component";
import {Clazz} from "../model/clazz";

const API_URL = 'http://localhost:8080/students'

@Injectable({
  providedIn: 'root'
})
export class StudentService {
  id: number = 1;
  students: Student[] = [];

  constructor(private httpClient: HttpClient) {
  }



  save(student: Student): Observable<any> {
    return this.httpClient.post(API_URL, student)
  }

  deleteById(id: number): Observable<any> {
    return this.httpClient.delete(API_URL + "/" + id)
  }

  getById(id: number): Observable<Student> {
    return this.httpClient.get<Student>(API_URL + "/" + id);
  }

  findAllClazz(): Observable<Clazz[]> {
    return this.httpClient.get<Clazz[]>('http://localhost:8080/clazz')
  }

  findOneClazz(id: number): Observable<Clazz> {
    return this.httpClient.get<Clazz>('http://localhost:8080/clazz' + id)
  }

  findByNamContaining(name: string): Observable<Student[]> {
    return this.httpClient.get<Student[]>(API_URL + "/search?search=" + name)
  }
  findAll(): Observable<Student[]> {
    return this.httpClient.get<Student[]>(API_URL);
  }
  findAllByClazz( a:string):Observable<any>{
    return this.httpClient.get<any>(API_URL+"/search-by-clazz?clazz="+a)
  }
}
