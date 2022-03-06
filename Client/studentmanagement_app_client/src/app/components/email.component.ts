import { HttpClient } from '@angular/common/http';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { Mail } from '../mail';

@Component({
  selector: 'app-email',
  templateUrl: './email.component.html',
  styleUrls: ['./email.component.css']
})
export class EmailComponent implements OnInit{

  subscription!: Subscription
  emailNotification: Mail =
  {
    name: '',
    email: '',
    message: ''
  };
  constructor(private http: HttpClient) { }


  onSubmit(){
  this.http.post<Mail>('http://localhost:8080/student/sendemail', this.emailNotification).subscribe(
        res => {
          this.emailNotification = res;
          console.log(this.emailNotification);
          alert('Email Sent successfully');
          location.reload();

        },
        err => {
          alert('An error has occured while sending email');
        });
        console.log("email sent");
  }

  ngOnInit(): void {
  }

}
