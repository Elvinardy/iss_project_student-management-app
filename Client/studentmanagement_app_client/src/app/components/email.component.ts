import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { Mail } from '../Mail';
import { Student } from '../student';
import { StudentService } from '../student.service';


@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit{

  students: Student[] = []
  subscription!: Subscription
  emailNotification: Mail =
  {
    name: '',
    email: '',
    subject: '',
    message: '',

  };

  mailSend!: string

  constructor(private http: HttpClient, private studentSvc: StudentService,
    private router: Router) { }

  ngOnInit(): void {
    this.getStudents();
  }

  public getStudents(): void {
    this.subscription = this.studentSvc.getStudents().subscribe({
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
/*   onSubmit(){
    this.http.post<Details>(`/sendmail`, this.dataset).subscribe(
        res => {
          this.dataset = res;
          console.log(this.dataset);
          alert('Email Sent successfully');
          this.dataset.name = '';
          this.dataset.message = '';
          this.dataset.email = '';
          console.log(res);
        });

  } */


  onSubmit(){
    console.log("sending message")
    this.studentSvc.sendEmail(this.emailNotification).then(
      result => {
          console.log(result.message);
          alert('Email Sent successfully');
          this.router.navigate(['/teachers']);
      }).catch ((e) => {
        console.log(e)
        alert('An error has occured')
      })
  /* this.http.post<Mail>(`student/sendemail`, this.emailNotification).subscribe(
        res => {
          this.emailNotification = res;
          console.log(this.emailNotification);
          alert('Email Sent successfully');
          location.reload();

        },
        err => {
          alert('An error has occured while sending email');
        });
        console.log("email sent"); */
  }


}

