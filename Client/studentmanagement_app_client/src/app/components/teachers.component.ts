import { DatePipe } from '@angular/common';
import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { FormBuilder, FormGroup } from '@angular/forms';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Attendance, Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-teachers',
  templateUrl: './teachers.component.html',
  styleUrls: ['./teachers.component.css']
})
export class TeachersComponent implements OnInit, OnDestroy {

  students: Student[] = [];
  attendance: Attendance[] =[];
  editStudent!: Student;
  deleteStudent!: Student;
  subscription!: Subscription
  form!: FormGroup;
  date!: Date;




  constructor(private studentService: StudentService,
    private router: Router, private fb: FormBuilder) { }

  ngOnInit(): void {
    this.getStudents();
    const now = (new Date()).toISOString().split('T')[0];
    this.form = this.fb.group({
      id: this.fb.control(''),
      date: this.fb.control(now),
      atdInfo: this.fb.control('present'),
    })
  }

/*   formatDate(){
    this.date=new Date();
    let latest_date =this.datePipe.transform(this.date, 'yyyy-MM-dd');
   } */

  public getStudents(): void {
    document.getElementById('add-student-form')?.click();
    this.subscription = this.studentService.getStudents().subscribe({
      next:(response: Student[]) => {
        this.students = response;
        console.log(response);
      },
      error:(error: HttpErrorResponse) => {
          alert(error.message);
          console.log("An error occured!")
      }
    }
      )
}

  public onUpdateStudent(student: Student): void {
    this.subscription = this.studentService.updateStudent(student).subscribe({
     next:(response: Student) => {
        console.log(response);
        this.getStudents();
      },
      error:(error: HttpErrorResponse) => {
        // to modify error message later
        alert(error.message);
      }
    });
  }

  public onDeleteStudent(studentId: number): void {
    this.subscription = this.studentService.deleteStudent(studentId).subscribe({
     next:(response: void) => {
        console.log(response);
        this.getStudents();
      },
      error:(error: HttpErrorResponse) => {
        // to modify error message later
        alert(error.message);
      }
    });
    this.router.navigate(['/teachers']);
  }

  onAddAttendance() {
    const attd = this.form.value as Attendance;
    document.getElementById('id');
    // this.students.push(id);
    this.studentService.postAttendance(attd)
      .then(() => console.log(attd))
      .catch(err => alert(err));
  }



  // for search function
  public searchStudents(key: String): void {
    console.log(key);
    const results: Student[] = [];
    for (const student of this.students) {
      // if not equal to -1, means the key present
      if (student.name.toLowerCase().indexOf(key.toLowerCase()) != -1
      || student.email.toLowerCase().indexOf(key.toLowerCase()) != -1
      || student.phone.toLowerCase().indexOf(key.toLowerCase()) != -1)
       {
        results.push(student);
      }
    }
    // show back all the students if key does not exists.
    this.students = results;
    if(results.length === 0 || !key) {
      this.getStudents();
    }
  }

  navigateToAdd() {
    this.router.navigate(['/add'])
  }
  // for Bootstrap Modal functionality
  public onOpenModal(mode: String, students: Student): void {
    const container = document.getElementById('main-container');
    const button = document.createElement('button');
    button.type = 'button';
    button.style.display = 'none';
    button.setAttribute('data-toggle','modal');

    if(mode === 'edit') {
      this.editStudent = students;
      button.setAttribute('data-target', '#updateStudentModal');
    }

    if(mode === 'delete') {
      this.deleteStudent = students;
      button.setAttribute('data-target', '#deleteStudentModal');
    }

    container?.appendChild(button);
    button.click();
}

ngOnDestroy(): void {
  this.subscription.unsubscribe();
}

}
