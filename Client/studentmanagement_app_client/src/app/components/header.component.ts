import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Student } from '../student';
import { StudentService } from '../student.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(private studentService: StudentService, private router: Router) { }

  students: Student[] = [];
  subscription!: Subscription;

  ngOnInit(): void {
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

  public getStudents(): void {
    document.getElementById('add-student-form')?.click();
    this.subscription = this.studentService.getStudents().subscribe({
      next:(response: Student[]) => {
        this.students = response;
        console.log(response);
      },
      error:(error: HttpErrorResponse) => {
          alert(error.message);
      }
    }
      )
}
navigateToAdd() {
  this.router.navigate(['/add'])
}

toEmail() {
  this.router.navigate(['/mail']);
}

}
