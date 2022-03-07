import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { StudentService } from './student.service';
import { MainComponent } from './components/main.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';
import { AddComponent } from './components/add.component';
import { LoginComponent } from './components/login.component';
import { LoginStatusComponent } from './components/login-status.component';
import { Router, RouterModule, Routes } from '@angular/router';
import {
  OKTA_CONFIG,
  OktaAuthModule,
  OktaCallbackComponent,
  OktaAuthGuard
} from '@okta/okta-angular';

import myAppConfig from './config/my-app-config';
import { TeachersComponent } from './components/teachers.component';
import { HeaderComponent } from './components/header.component';
import { EmailComponent } from './components/email.component';




const oktaConfig = Object.assign({
  onAuthRequired: (oktaAuth, injector) => {
    const router = injector.get(Router);
    // redirect to main user page
    router.navigate(['/login']);
  }
}, myAppConfig.oidc);
const routes: Routes = [
  { path: 'login/callback', component: OktaCallbackComponent},
  { path: '', component: MainComponent },
  { path: 'teachers', component: TeachersComponent, canActivate: [ OktaAuthGuard ]},
  { path: 'add', component: AddComponent, canActivate: [ OktaAuthGuard ]},
  { path: 'login', component: LoginComponent},
  { path: 'mail', component: EmailComponent, canActivate: [ OktaAuthGuard ]},
  { path: '**', redirectTo: 'login', pathMatch: 'full'}
 ]

@NgModule({
  declarations: [
    AppComponent,
    MainComponent,
    AddComponent,
    LoginComponent,
    LoginStatusComponent,
    TeachersComponent,
    HeaderComponent,
    EmailComponent,

  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    OktaAuthModule,
    FormsModule, ReactiveFormsModule, NgbModule,
    RouterModule.forRoot(routes),

  ],

  providers: [StudentService, { provide: OKTA_CONFIG, useValue: oktaConfig },
             // { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true}
            ],
              // token for HTTP interceptors
              // mulit: true cos we can have multiple interceptors
  bootstrap: [AppComponent]
})
export class AppModule { }
