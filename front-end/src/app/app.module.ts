import { ReceveurDonService } from './services/receveur-don.service';
import { ReceveurDon } from './entities/receveur-don';
import { DonneurService } from './services/donneur.service';
import { FonctionService } from './services/fonction.service';
import { TypeActionService } from './services/type-action.service';
import { ActiviteService } from './services/activite.service';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import {CommonModule} from '@angular/common';
import {HttpModule} from '@angular/http';
import { HttpClientModule } from '@angular/common/http';
import {ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
//les services
import {AdherentService} from '../app/services/adherent.service';
import {AdresseService} from '../app/services/adresse.service';
import { ServService } from './services/serv.service';
import { ProfessionService } from './services/profession.service';
import { DepartementService } from './services/departement.service';
import { StructureService } from './services/structure.service';
import { TypeAdherentService } from './services/type-adherent.service';
import { CommunauteService } from './services/communaute.service';
import { BureauVoteService } from './services/bureau-vote.service';


//les components
import { AppComponent } from './app.component';
import { LoginComponent } from './login/login.component';
import { MainModule } from './main/main.module';
import { AjouterAdherentComponent } from './adherents/ajouter-adherent/ajouter-adherent.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { FormsModule } from '@angular/forms';
import { InfoGComponent } from './adherents/ajouter-adherent/info-g/info-g.component';
import { DonService } from './services/don.service';
import { AdressesComponent } from './adherents/ajouter-adherent/adresses/adresses.component';
import { ExtraServiceService } from './services/extra-service.service';
import { DonnateurLoginComponent } from './donnateur-login/donnateur-login.component';
import { LiquideService } from './services/liquide.service';


@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AjouterAdherentComponent,
    ForgotPasswordComponent,
    InfoGComponent,
    AdressesComponent,
    DonnateurLoginComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    MainModule,
    HttpModule,
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AdherentService,AdresseService,ServService,ExtraServiceService,ProfessionService,DepartementService,StructureService,TypeAdherentService,ActiviteService,CommunauteService,BureauVoteService,TypeActionService,DonService,DonneurService,ReceveurDonService,FonctionService,LiquideService],
  bootstrap: [AppComponent]
})
export class AppModule { }
