import { Adherent } from './../../../entities/adherent';
import { Component, OnInit } from '@angular/core';
import { AdherentService } from '../../../services/adherent.service';
import {Router} from "@angular/router";
import { ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-membre-list',
  templateUrl: './membre-list.component.html',
  styleUrls: ['./membre-list.component.css']
})
export class MembreListComponent implements OnInit {
  private _adherentList:Adherent[];
  private _adherentDelete:Adherent;
  @ViewChild('closeModal') closeModal: ElementRef;
  constructor(private _AdherentService:AdherentService,private _router:Router) { }

  ngOnInit() {
    this._AdherentService.getMembres().subscribe((adherents)=>{
      console.log(adherents);
      this._adherentList=adherents;
      console.log(this._adherentList);
    },(error)=>{
     console.log(error);
    });
  }
  updateAdherent(adherent:Adherent){
  this._AdherentService.setter(adherent);
  this._router.navigate(['/adherent/add']);
  }
  detailsAdherent(adherent:Adherent){
  this._router.navigateByUrl("/assoc/membres/list/"+adherent.id_adherent+"/details")
  }
  sendAdherent(adherent:Adherent){
    this._adherentDelete=new Adherent();
    this._adherentDelete=adherent;
  }

  deleteAdherent(){
    this._AdherentService.deleteAdherent(this._adherentDelete.id_adherent).subscribe((data)=>{
    console.log(data);
    this._adherentList.slice(this._adherentList.indexOf(this._adherentDelete),1);
  },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
  }

  get adherentList():Adherent[]{
    return  this._adherentList;
  }
}
