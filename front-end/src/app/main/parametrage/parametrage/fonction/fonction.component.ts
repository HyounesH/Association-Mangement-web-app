import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef} from '@angular/core';
import {Router} from '@angular/router';
import { Fonction } from '../../../../entities/fonction';
import { FonctionService } from '../../../../services/fonction.service';

@Component({
  selector: 'app-fonction',
  templateUrl: './fonction.component.html',
  styleUrls: ['./fonction.component.css']
})
export class FonctionComponent implements OnInit {

  public fonctionList:Fonction[];
  private _fonctionToDelete:Fonction;
  public status_fonction:string;
  public status:string;
  public fonction:Fonction=new Fonction();
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addFonction') addFonction:ElementRef;
   constructor(private _router:Router,private _fonctionService:FonctionService) { }

   ngOnInit() {

     this._fonctionService.getFonctions().subscribe((fonctions)=>{
      console.log(fonctions);
      this.fonctionList=fonctions;
     },(error)=>{
       console.log(error);
     });
     this.status_fonction="Ajouter une nouvelle fonction";
     this.status="Enregistrer";
   }

   deleteFonction(){
   this._fonctionService.deleteFonction(this._fonctionToDelete.fonction_id).subscribe((data)=>{
    console.log(data);
    this.fonctionList.slice(this.fonctionList.indexOf(this._fonctionToDelete,1));
   },(error)=>{
     console.log(error);
   });
   this.closeModal.nativeElement.click();
   window.location.reload();
   }

   fonctionToDelete(fonction:Fonction){
     this._fonctionToDelete=new Fonction();
     this._fonctionToDelete=fonction;
     console.log(this._fonctionToDelete);
   }

   updateFonction(_fonction:Fonction){
     this.fonction=_fonction;
     this.status_fonction="Modifier une fonction";
     this.status="Modifier";
   }
   nouvelleFonction(){
     this.fonction=new Fonction();
     this.status_fonction="ajouter une nouvelle fonction";
     this.status="Enregistrer";
   }
   add(){
    console.log(this.fonction);
    this._fonctionService.saveFonction(this.fonction).subscribe((data)=>{
     console.log(data);
    },(error)=>{
    console.log(error);
    });
   this.addFonction.nativeElement.click();
   window.location.reload();
   }

   update(){
    this._fonctionService.updateFonction(this.fonction).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
    this.addFonction.nativeElement.click();
    window.location.reload();
   }


   NavigateToStructure(){this._router.navigateByUrl("assoc/parametrage");}
   NavigateToService(){this._router.navigateByUrl("assoc/parametrage/service");}
   NavigateToDepartement(){this._router.navigateByUrl("assoc/parametrage/departement");}
   NavigateToActivite(){this._router.navigateByUrl("assoc/parametrage/activite");}
   NavigateToProfession(){this._router.navigateByUrl("assoc/parametrage/profession");}
   NavigateToCommunaute(){this._router.navigateByUrl("assoc/parametrage/communaute");}
   NavigateToBureauVote(){this._router.navigateByUrl("assoc/parametrage/bureauVote");}
   NavigateTotypeAction(){this._router.navigateByUrl("assoc/parametrage/typeAction");}
   NavigateToFonction(){this._router.navigateByUrl("assoc/parametrage/fonction");}
}
