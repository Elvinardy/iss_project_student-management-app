import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AddComponent } from './components/add.component';
import { LoginComponent } from './components/login.component';
import { MainComponent } from './components/main.component';

const routes: Routes = [
 { path: '', component: MainComponent },
 { path: 'add', component: AddComponent },
 { path: 'login', component: LoginComponent}
]

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
