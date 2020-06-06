import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from './login/login.component';
import { HomeComponent } from './home/home.component';
import { HomeAdminComponent } from './homeAdmin/home-admin.component';

const routes: Routes = [
  { path: '', component: LoginComponent },
  {path: 'homeUser', component: HomeComponent},
  {path: 'homeAdmin', component: HomeAdminComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
