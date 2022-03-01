import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, NgForm, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-add',
  templateUrl: './add.component.html',
  styleUrls: ['./add.component.css']
})
export class AddComponent implements OnInit {

  public students: Student[] = [];
  subscription!: Subscription;
  form!: FormGroup;

  constructor(private fb: FormBuilder, private studentService: StudentService,
    private router: Router) { }


  ngOnInit(): void {
    /* this.form = this.fb.group({
      name: this.fb.control('', [Validators.required, Validators.minLength(3)]),
      email: this.fb.control('@edu.sg', Validators.email),
      classInfo: this.fb.control('', [ Validators.required, Validators.minLength(3)]),
      phone: this.fb.control('+65',[Validators.required]),
      imageUrl: this.fb.control(''),
      remarks: this.fb.control("Key in your student comments here.", Validators.minLength(5))
    }) */
  }
  public getStudents(): void {
    document.getElementById('add-student-form')?.click();
    this.subscription = this.studentService.getStudents().subscribe({
      next:(response: Student[]) => {
        this.students = response;
      },
      error:(error: HttpErrorResponse) => {
          alert(error.message);
      }
    }
      )
}

  public onAddStudent(addForm: NgForm): void {
   this.studentService.addStudent(addForm.value).subscribe({
     next:(response: Student) => {
        console.log(response);
        this.getStudents();
        addForm.reset();
        this.router.navigate([''])
      },
      error:(error: HttpErrorResponse) => {
        // to modify error message later
        alert(error.message);
        addForm.reset();

      }
    });
  }

  goBack() {
    this.router.navigate([''])
  }

}
