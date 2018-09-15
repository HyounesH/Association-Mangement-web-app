import { DetailsDonSuiviComponent } from './main/suivi/details-don-suivi/details-don-suivi.component';
import { MembreDetailsComponent } from './main/membre/membre-details/membre-details.component';
import { AddMembreComponent } from './main/membre/add-membre/add-membre.component';
import { MembreListComponent } from './main/membre/membre-list/membre-list.component';
import { Adherent } from './entities/adherent';
import { DonInfoComponent } from './main/dons/ajouter-don/don-info/don-info.component';
import { DonneurInfoComponent } from './main/dons/ajouter-don/donneur-info/donneur-info.component';
import { AdressesComponent } from './adherents/ajouter-adherent/adresses/adresses.component';
import { TypeActionComponent } from './main/parametrage/parametrage/type-action/type-action.component';
import { CommunauteComponent } from './main/parametrage/parametrage/communaute/communaute.component';
import { InfoGComponent } from './adherents/ajouter-adherent/info-g/info-g.component';
import { MainComponent } from './main/main.component';
import { ActiviteComponent } from './main/parametrage/parametrage/activite/activite.component';
import { DeparetementComponent } from './main/parametrage/parametrage/deparetement/deparetement.component';
import { ParametrageComponent } from './main/parametrage/parametrage/parametrage.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { Listener } from 'selenium-webdriver';
import { AdherentListComponent } from './main/adherents/adherent-list/adherent-list.component';
import { AdherentAddComponent } from './main/adherents/adherent-add/adherent-add.component';
import { ContentComponent } from './main/content/content.component';
import { StructureComponent } from './main/parametrage/parametrage/structure/structure.component';
import { ServiceComponent } from './main/parametrage/parametrage/service/service.component';
import { ProfessionComponent } from './main/parametrage/parametrage/profession/profession.component';
import { AjouterAdherentComponent } from './adherents/ajouter-adherent/ajouter-adherent.component';
import { LoginComponent } from './login/login.component';
import { ForgotPasswordComponent } from './forgot-password/forgot-password.component';
import { BureauVoteComponent } from './main/parametrage/parametrage/bureau-vote/bureau-vote.component';
import { FonctionComponent } from './main/parametrage/parametrage/fonction/fonction.component';
import { ListDonsComponent } from './main/dons/list-dons/list-dons.component';
import { AjouterDonComponent } from './main/dons/ajouter-don/ajouter-don.component';
import { DashbordComponent } from './main/dashbord/dashbord.component';
import { DetailsAdherentComponent } from './main/adherents/details-adherent/details-adherent.component';
import { InformationGComponent } from './main/membre/add-membre/information-g/information-g.component';
import { AdresseComponent } from './main/membre/add-membre/adresse/adresse.component';
import { DonnateurComponent } from './main/donnateur/donnateur.component';
import { DonnateurLoginComponent } from './donnateur-login/donnateur-login.component';
import { EntreesComponent } from './main/rapport/entrees/entrees.component';
import { SortiesComponent } from './main/rapport/sorties/sorties.component';
import { DepensesComponent } from './main/rapport/depenses/depenses.component';
import { ListDonSuiviComponent } from './main/suivi/list-don-suivi/list-don-suivi.component';

const routes: Routes = [
  {
    path:'assoc',
    component:MainComponent,
    children:[
      {
        path:'',
        component:DashbordComponent
      },
      {
        path:'rapport/entrees',
        component:EntreesComponent
      },
      {
        path:'rapport/sorties',
        component:SortiesComponent
      },
      {
        path:'rapport/depenses',
        component:DepensesComponent
      },
      {
        path:'adherent/list',
        component:AdherentListComponent
      },
      {
        path:'adherent/list/:id/details',
        component:DetailsAdherentComponent
      },
      {
        path:'membres/list',
        component:MembreListComponent
      },
      {
        path:'membres/list/:id/details',
        component:MembreDetailsComponent
      },
      {
        path:'membres/add',
        component:AddMembreComponent,
        children:[
          {
            path:'',
            component:InformationGComponent
          },
          {
            path:':id/adresses',
            component:AdresseComponent
          }
      ]
      },
      {
        path:'adherent/add',
        component:AjouterAdherentComponent,
        children:[
          {
            path:'',
            component:InfoGComponent
          },
          {
            path:':id/adresses',
            component:AdressesComponent
          }
        ]
      },
      {
      path:'dons/list',
      component:ListDonsComponent
      },
      {
        path:'donnateurs',
        component:DonnateurComponent
      },
      {
     path:'dons/add',
     component:AjouterDonComponent,
     children:[
       {
         path:'',
         component:DonneurInfoComponent
       },
       {
         path:':id/donData',
         component:DonInfoComponent
       }
     ]
      },
      {
        path:'parametrage',
        component:ParametrageComponent,
        children:[
          {
            path:'',
            component:StructureComponent
          },
          {
            path:'service',
            component:ServiceComponent
          },
          {
            path:'departement',
            component:DeparetementComponent
          },
          {
            path:'profession',
            component:ProfessionComponent
          },
          {
            path:'activite',
            component:ActiviteComponent
          },
          {
            path:'communaute',
            component:CommunauteComponent
          },
          {
            path:'bureauVote',
            component:BureauVoteComponent
          },
          {
            path:'fonction',
            component:FonctionComponent
          },
          {
            path:'typeAction',
            component:TypeActionComponent
          }
          ]
      },
   ]
  },
  {
  path:'assoc/donnateur/suivi/list',
  component:ListDonSuiviComponent
  },
  {
    path:'assoc/donnateur/suivi/list/:id/details',
    component:DetailsDonSuiviComponent
  },
  {
    path:'',
    component:LoginComponent
  },
  {
    path:'forgot-password',
    component:ForgotPasswordComponent
  },
  {
   path:'login/donnateur',
   component:DonnateurLoginComponent
  },
  {
  path:'**',
  component:MainComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
