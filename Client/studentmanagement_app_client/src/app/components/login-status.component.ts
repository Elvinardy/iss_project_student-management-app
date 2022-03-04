import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { OktaAuthService } from '@okta/okta-angular';

@Component({
  selector: 'app-login-status',
  templateUrl: './login-status.component.html',
  styleUrls: ['./login-status.component.css']
})
export class LoginStatusComponent implements OnInit {

  isAuthenticated: boolean = false;
  userFullName?: string;

  constructor(private oktaAuthService: OktaAuthService, private router: Router) { }

  ngOnInit(): void {
    // subscribe to authentication state
    this.oktaAuthService.$authenticationState.subscribe(
      (result) => {
        this.isAuthenticated = result;
        this.getUserDetails();
        this.router.navigate(['/teachers']);

      })
   }
        getUserDetails() {
          if(this.isAuthenticated) {
            this.oktaAuthService.getUser().then(
              (res) => {
                this.userFullName = res.name;
              }
            );
      }
      }
      logout() {
        this.oktaAuthService.signOut();
    }

}
