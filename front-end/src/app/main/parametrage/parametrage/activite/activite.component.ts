import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef} from '@angular/core';
import { Activite } from '../../../../entities/activite';
import { ActiviteService } from '../../../../services/activite.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-activite',
  templateUrl: './activite.component.html',
  styleUrls: ['./activite.component.css']
})
export class ActiviteComponent implements OnInit {
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addActivite') addActivite:ElementRef;
  public activiteList:Activite[];
  private _activiteToDelete:Activite;
  public status_activite:string;
  public status:string;
  public action_nom_validate:boolean=true;
  public activite:Activite=new Activite();
  public activiteForm:FormGroup;


  constructor(private _router:Router,private _activiteService:ActiviteService) { }

  ngOnInit() {

    this.activiteForm=new FormGroup({
      'action_nom':new FormControl(this.activite.action_nom,Validators.required),
      "lieu":new FormControl(this.activite.lieu,Validators.required),
      "dateRealise":new FormControl(this.activite.dateRealise,Validators.required),
      "objectif":new FormControl(this.activite.objectif,Validators.required)
      });
    this._activiteService.getActivites().subscribe((activites)=>{
      console.log(activites);
      this.activiteList=activites;
     },(error)=>{
       console.log(error);
     });
     this.status_activite="Nouvelle Activité";
     this.status="Enregistrer";
  }
  deleteActivite(){
    this._activiteService.deleteActivite(this._activiteToDelete.action_id).subscribe((data)=>{
     console.log(data);
     this.activiteList.slice(this.activiteList.indexOf(this._activiteToDelete,1));
    },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
    }
    ActiviteToDelete(activite:Activite){
      this._activiteToDelete=new Activite();
      this._activiteToDelete=activite;
    }

  updateActivite(_activite:Activite){
    console.log('ID ', _activite.action_id);
    this.activite=_activite;
    this.status_activite="Modifier Activité";
    this.status="Modifier";
  }
  nouveauActivite(){
    this.activite=new Activite();
    this.status_activite="Nouvelle Activité";
    this.status="Enregistrer";
  }

  add(){
     this._activiteService.saveActivite(this.activite).subscribe((data)=>{
      console.log(data);
     },(error)=>{
     console.log(error);
     });

    this.addActivite.nativeElement.click();
    window.location.reload();
    }

  update(){
   this._activiteService.updateActivite(this.activite).subscribe((data)=>{
        console.log(data);
      },(error)=>{
        console.log(error);
      });
    this.addActivite.nativeElement.click();
    window.location.reload();
  }

  get nom(){
    return  this.activiteForm.get('action_nom');
  }
  get place(){
    return this.activiteForm.get("lieu");
  }
  get finishDate(){
    return this.activiteForm.get("dateRealise");
  }
  get purpose(){
    return this.activiteForm.get("objectif");
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
