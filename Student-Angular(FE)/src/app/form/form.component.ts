import {Component, OnInit} from '@angular/core';
import {Student} from "../model/student";
import {FormControl, FormGroup} from "@angular/forms";
import {Clazz} from "../model/clazz";
import {ActivatedRoute, Router} from "@angular/router";
import {StudentService} from "../service/student.service";

@Component({
  selector: 'app-form',
  templateUrl: './form.component.html',
  styleUrls: ['./form.component.css']
})
export class FormComponent implements OnInit{
  student!:Student;
  formStudent!:FormGroup;
  clazz: Clazz[] = []
  claz!: Clazz;


  constructor (private routerActive:ActivatedRoute,
    private router: Router,
           private studentService: StudentService) {
    this.studentService.findAllClazz().subscribe((data ) => {
      this.clazz=data;
      })

  }

  ngOnInit() :void {
    const id = Number(this.routerActive.snapshot.paramMap.get("id"))
    this.formStudent=new FormGroup({
      id :new FormControl(''),
      name :new FormControl(''),
      dob :new FormControl(''),
      clazz :new FormGroup({
        id:new FormControl('')
    })
    })
    this.studentService.getById(id).subscribe((rs)=>{
      this.student=rs
      this.formStudent.patchValue(rs);
    })

  }
  onSubmit(){
    this.student=this.formStudent.value;
    this.studentService.save(this.student).subscribe(()=> {
      this.router.navigate(['/student'])
    },error => {
      console.log("demo")
    })
  }
}
