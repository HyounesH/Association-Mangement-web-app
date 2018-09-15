import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import {CommonModule} from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { FooterComponent } from './footer/footer.component';
import { ToolbarComponent } from './toolbar/toolbar.component';
import { ContentComponent } from './content/content.component';
import { NavbarComponent } from './navbar/navbar.component';
import { MainComponent } from './main.component';
import { AdherentListComponent } from './adherents/adherent-list/adherent-list.component';
import { AdherentAddComponent } from './adherents/adherent-add/adherent-add.component';
import { ParametrageComponent } from './parametrage/parametrage/parametrage.component';
import { StructureComponent } from './parametrage/parametrage/structure/structure.component';
import { DeparetementComponent } from './parametrage/parametrage/deparetement/deparetement.component';
import { ServiceComponent } from './parametrage/parametrage/service/service.component';
import { ActiviteComponent } from './parametrage/parametrage/activite/activite.component';
import { ProfessionComponent } from './parametrage/parametrage/profession/profession.component';
import { CommunauteComponent } from './parametrage/parametrage/communaute/communaute.component';
import { BureauVoteComponent } from './parametrage/parametrage/bureau-vote/bureau-vote.component';
import { TypeActionComponent } from './parametrage/parametrage/type-action/type-action.component';
import { FonctionComponent } from './parametrage/parametrage/fonction/fonction.component';
import { ListDonsComponent } from './dons/list-dons/list-dons.component';
import { AjouterDonComponent } from './dons/ajouter-don/ajouter-don.component';
import { DonneurInfoComponent } from './dons/ajouter-don/donneur-info/donneur-info.component';
import { DonInfoComponent } from './dons/ajouter-don/don-info/don-info.component';
import { DashbordComponent } from './dashbord/dashbord.component';
import { DetailsAdherentComponent } from './adherents/details-adherent/details-adherent.component';
import { AddMembreComponent } from './membre/add-membre/add-membre.component';
import { MembreListComponent } from './membre/membre-list/membre-list.component';
import { InformationGComponent } from './membre/add-membre/information-g/information-g.component';
import { AdresseComponent } from './membre/add-membre/adresse/adresse.component';
import { MembreDetailsComponent } from './membre/membre-details/membre-details.component';
import { DonnateurComponent } from './donnateur/donnateur.component';
import { DepensesComponent } from './rapport/depenses/depenses.component';
import { EntreesComponent } from './rapport/entrees/entrees.component';
import { SortiesComponent } from './rapport/sorties/sorties.component';
import { ListDonSuiviComponent } from './suivi/list-don-suivi/list-don-suivi.component';
import { DetailsDonSuiviComponent } from './suivi/details-don-suivi/details-don-suivi.component';


@NgModule({
    declarations: [
    FooterComponent,
    NavbarComponent,
    ToolbarComponent,
    ContentComponent,
    MainComponent,
    AdherentListComponent,
    AdherentAddComponent,
    ParametrageComponent,
    StructureComponent,
    DeparetementComponent,
    ServiceComponent,
    ActiviteComponent,
    ProfessionComponent,
    CommunauteComponent,
    BureauVoteComponent,
    TypeActionComponent,
    FonctionComponent,
    ListDonsComponent,
    AjouterDonComponent,
    DonneurInfoComponent,
    DonInfoComponent,
    DashbordComponent,
    DetailsAdherentComponent,
    AddMembreComponent,
    MembreListComponent,
    InformationGComponent,
    AdresseComponent,
    MembreDetailsComponent,
    DonnateurComponent,
    DepensesComponent,
    EntreesComponent,
    SortiesComponent,
    ListDonSuiviComponent,
    DetailsDonSuiviComponent
    ],
    imports : [
        RouterModule,
        CommonModule,
        FormsModule,
        ReactiveFormsModule
    ],
    exports: [ MainComponent  ]
})

export class MainModule {
}
