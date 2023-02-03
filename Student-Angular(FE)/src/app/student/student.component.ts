import {Component, OnInit} from '@angular/core';
import {FormGroup} from "@angular/forms";
import {Student} from "../model/student";
import {StudentService} from "../service/student.service";
import {Observable} from "rxjs";
import {Clazz} from "../model/clazz";

@Component({
  selector: 'app-student',
  templateUrl: './student.component.html',
  styleUrls: ['./student.component.css']
})
export class StudentComponent implements OnInit {

  formStudent!: FormGroup;
  students: Student[] = [];
  student!: Observable<Student>;
  clazz:Clazz[]=[]
  claz!: Observable<Clazz>;

  constructor(private studentService: StudentService
  ) {
  }

  ngOnInit(): void {
    this.studentService.findAll().subscribe((data) => {
      this.students = data;
    });
  }

  delete(id: number) {
    if (confirm("Are you want to delete this student?")) {
      this.studentService.deleteById(id).subscribe(() => {
        this.ngOnInit()
      })
    }
  }
  search(name:string){
    this.studentService.findByNamContaining(name).subscribe((data)=>{
      this.students=data
    })
  }
  searchByClazz(a:string){
    this.studentService.findAllByClazz(a).subscribe((data)=>{
      this.students=data
    })
  }
}
