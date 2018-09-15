import { Communaute } from './../../../../entities/communaute';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ViewChild, ElementRef} from '@angular/core';
import { CommunauteService } from '../../../../services/communaute.service';

@Component({
  selector: 'app-communaute',
  templateUrl: './communaute.component.html',
  styleUrls: ['./communaute.component.css']
})
export class CommunauteComponent implements OnInit {

  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addCommunaute') addCommunaute:ElementRef;
  public communauteList:Communaute[];
  private _communauteToDelete:Communaute
  public status_communaute:string;
  public status:string;
  public communaute:Communaute=new Communaute();
  constructor(private _router:Router,private _communauteService:CommunauteService) { }


  ngOnInit() {
    this._communauteService.getCommunautes().subscribe((data)=>{
      this.communauteList=data;
     },(error)=>{
       console.log(error);
     });
     this.status_communaute="Nouveau Communaute";
     this.status="Enregistrer";
  }

  deleteCommunaute(){
    this._communauteService.deleteCommunaute(this._communauteToDelete.communaute_id).subscribe((data)=>{
     console.log(data);
     this.communauteList.slice(this.communauteList.indexOf(this._communauteToDelete,1));
    },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
    }
  communauteToDelete(communaute:Communaute){
  this._communauteToDelete=new Communaute();
  this._communauteToDelete=communaute;
  }

  updateCommunaute(_communaute:Communaute){
    this.communaute=_communaute;
    this.status_communaute="Modifier Communaute";
    this.status="Modifier";
  }
  nouveauCommunaute(){
    this.communaute=new Communaute();
    this.status_communaute="Nouveau Communaute";
    this.status="Enregistrer";
  }
  add(){
   this._communauteService.saveCommunaute(this.communaute).subscribe((data)=>{
    console.log(data);
   },(error)=>{
   console.log(error);
   });
  this.addCommunaute.nativeElement.click();
  window.location.reload();
  }
  Update(){
    this._communauteService.updateCommunaute(this.communaute).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
    this.addCommunaute.nativeElement.click();
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
