import { Profession } from './../../../../entities/profession';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProfessionService } from '../../../../services/profession.service';
import { ViewChild, ElementRef} from '@angular/core';
import { locale } from '../../../../../dist/vendor/moment/moment';

@Component({
  selector: 'app-profession',
  templateUrl: './profession.component.html',
  styleUrls: ['./profession.component.css']
})
export class ProfessionComponent implements OnInit {
 private _professionList:Profession[];
 private _professionToDelete:Profession;
 public status_profession:string;
 public status:string;
 public profession:Profession=new Profession();
 @ViewChild('closeModal') closeModal: ElementRef;
 @ViewChild('addProfession') addProfession:ElementRef;
  constructor(private _router:Router,private _professionService:ProfessionService) { }

  ngOnInit() {

    this._professionService.getProfessions().subscribe((professions)=>{
     console.log(professions);
     this._professionList=professions;
    },(error)=>{
      console.log(error);
    });
    this.status_profession="Nouvelle Profossion";
    this.status="Enregistrer";
  }

  deleteProfession(){
  this._professionService.deleteProfession(this._professionToDelete.profession_id).subscribe((data)=>{
   console.log(data);
   this._professionList.slice(this._professionList.indexOf(this._professionToDelete,1));
  },(error)=>{
    console.log(error);
  });
  this.closeModal.nativeElement.click();
  window.location.reload();
  }

  professionToDelete(profession:Profession){
    this._professionToDelete=new Profession();
    this._professionToDelete=profession;
    console.log(this._professionToDelete);
  }

  get professionList():Profession[]{
    return this._professionList;
  }

  updateProfession(_profession:Profession){
    this.profession=_profession;
    this.status_profession="Modifier une Profession";
    this.status="Modifier";
  }
  nouveauProfession(){
    this.profession=new Profession();
    this.status_profession="Nouvelle Profossion";
    this.status="Enregistrer";
  }
  add(){
   console.log(this.profession);
   this._professionService.saveProfession(this.profession).subscribe((data)=>{
    console.log(data);
   },(error)=>{
   console.log(error);
   });
  this.addProfession.nativeElement.click();
  window.location.reload();
  }

  update(){
    this._professionService.updateProfession(this.profession).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
    this.addProfession.nativeElement.click();
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
