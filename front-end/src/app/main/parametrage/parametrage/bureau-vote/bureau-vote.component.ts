import { BureauVoteService } from './../../../../services/bureau-vote.service';
import { BureauVote } from './../../../../entities/bureau-vote';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-bureau-vote',
  templateUrl: './bureau-vote.component.html',
  styleUrls: ['./bureau-vote.component.css']
})
export class BureauVoteComponent implements OnInit {
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addBV') addBV:ElementRef;
  public bvList:BureauVote[];
  private _bvToDelete:BureauVote
  public status_bv:string;
  public status:string;
  public bv:BureauVote=new BureauVote();
  constructor(private _router:Router,private _bvService:BureauVoteService) { }


  ngOnInit() {
    this._bvService.getBureauVotes().subscribe((data)=>{
      this.bvList=data;
     },(error)=>{
       console.log(error);
     });
     this.status_bv="Nouveau Bureau de vote";
     this.status="Enregistrer";
  }

  deleteBV(){
    this._bvService.deleteBureauVote(this._bvToDelete.bureauVote_id).subscribe((data)=>{
     console.log(data);
     this.bvList.slice(this.bvList.indexOf(this._bvToDelete,1));
    },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
    }
  bVToDelete(bv:BureauVote){
  this._bvToDelete=new BureauVote();
  this._bvToDelete=bv;
  }

  updateBv(_bv:BureauVote){
    this.bv=_bv;
    this.status_bv="Modifier les informations de bureau de vote";
    this.status="Modifier";
  }
  nouveauBv(){
    this.bv=new BureauVote();
    this.status_bv="ajouter un Nouveau bureau de vote";
    this.status="Enregistrer";
  }
  add(){
   this._bvService.saveBureauVote(this.bv).subscribe((data)=>{
    console.log(data);
   },(error)=>{
   console.log(error);
   });
  this.addBV.nativeElement.click();
  window.location.reload();
  }
  update(){
    this._bvService.updateBureauVote(this.bv).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
  this.addBV.nativeElement.click();
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
