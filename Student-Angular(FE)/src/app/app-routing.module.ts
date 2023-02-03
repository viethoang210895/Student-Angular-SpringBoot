import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import {StudentComponent} from "./student/student.component";
import {NavbarComponent} from "./navbar/navbar.component";
import {FormComponent} from "./form/form.component";

const routes: Routes = [
  {
    path: '', component: NavbarComponent
  },
  {
    path: 'student', component: StudentComponent
  },
  {
    path: 'form/:id', component: FormComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
