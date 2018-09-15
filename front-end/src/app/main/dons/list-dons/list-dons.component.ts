import { AdherentService } from './../../../services/adherent.service';
import { Don } from './../../../entities/don';
import { DonService } from './../../../services/don.service';
import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef} from '@angular/core';
import { Adherent } from '../../../entities/adherent';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-list-dons',
  templateUrl: './list-dons.component.html',
  styleUrls: ['./list-dons.component.css']
})
export class ListDonsComponent implements OnInit {
  public listDon:Don[];
  public don:Don=new Don();
  public adherent:Adherent=new Adherent();
  private _donToDelete:Don=new Don();
  public donForm:FormGroup;
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('closeModalModif') closeModalModif: ElementRef;
  constructor(private _serviceDon:DonService,private _adherentService:AdherentService) { }

  ngOnInit() {
    this.donForm=new FormGroup({
      "description_don":new FormControl(this.don.description_don,Validators.required),
      "date_don":new FormControl(this.don.date_don,Validators.required),
      "montant":new FormControl(this.don.montant,[Validators.required,Validators.pattern("^[0-9]+$")]),
      "num_compte_banque":new FormControl(this.don.num_compte_banque,[Validators.required,Validators.pattern("^[0-9]+$")]),
      "nom_banque":new FormControl(this.don.nom_banque,[Validators.required,Validators.pattern("^[a-zA-Z]+$")]),
      "date_cheque":new FormControl(this.don.date_cheque,Validators.required),
      "etat":new FormControl(this.don.etat,Validators.required)
     });
   this._serviceDon.getDons().subscribe((data)=>{
     console.log(data);
   this.listDon=data;
   },(error)=>{
     console.log(error);
   })
  }
  deleteDon(don:Don){
   this._donToDelete=don;
  }
  delete(){
    this._serviceDon.deleteDon(this._donToDelete.id_don).subscribe((data)=>{
    console.log(data);
    },(error)=>{
   console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
  }
  detailsDon(don:Don){
   this.don=don;
   this._adherentService.getAdherent(don.receveur_don.code_employe).subscribe((data)=>{
   console.log(data);
   this.adherent=data;
   this.adherent.adresse=data.adresses[0];
   },(error)=>{
     console.log(error);
   });
  }

  updateDon(don:Don){
    this.don=don;
  }
  updateDonF(){
  this._serviceDon.updateDon(this.don).subscribe((data)=>{
    console.log(data);
  },(error)=>{
    console.log(error);
  });
  this.closeModalModif.nativeElement.click();
  window.location.reload();
  }
  get description(){
    return this.donForm.get("description_don");
  }
  get donDate(){
    return this.donForm.get("date_don");
  }
  get donMontant(){
    return this.donForm.get("montant");
  }
  get compteNumberBanc(){
    return this.donForm.get("num_compte_banque");
  }
  get chequeDate(){
    return this.donForm.get("date_cheque");
  }
  get state(){
    return this.donForm.get("etat");
  }
  get bancName(){
    return this.donForm.get("nom_banque");
  }


}
