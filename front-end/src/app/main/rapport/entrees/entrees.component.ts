import { Donneur } from './../../../entities/donneur';
import { Router } from '@angular/router';
import { AdresseService } from './../../../services/adresse.service';
import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { DonService } from '../../../services/don.service';
import { Don } from '../../../entities/don';
import { AdherentService } from '../../../services/adherent.service';
import { ReceveurDon } from '../../../entities/receveur-don';
import { Adherent } from '../../../entities/adherent';

@Component({
  selector: 'app-entrees',
  templateUrl: './entrees.component.html',
  styleUrls: ['./entrees.component.css']
})
export class EntreesComponent implements OnInit {
  public listMateriel : Don[];
  public listArgent : Don[];
  public donateur : Donneur=new Donneur();
  public adherent:Adherent =new Adherent();

  @ViewChild('closeModal') closeModal: ElementRef;
  constructor(private _router:Router ,private _serviceDon : DonService,private _serviceAdherent : AdherentService,private _adresseService:AdresseService) { }

  ngOnInit() {
    this._serviceDon.getMaterielEntrant().subscribe((data)=>{
      console.log(data);
    this.listMateriel=data;
    },(error)=>{
      console.log(error);
    });

    this._serviceDon.getArgentEntrant().subscribe((data)=>{
      console.log(data);
    this.listArgent=data;
    },(error)=>{
      console.log(error);
    });
  }

  details(code_employe:Number,donateur:Donneur){
      this.donateur = donateur;
      this._serviceAdherent.getAdherent(code_employe).subscribe((response)=>{
      this.adherent=response;
      this.adherent.adresse=response.adresses[0];
      },(error)=>{
        console.log(error);
      });
    this.closeModal.nativeElement.click();
  }
  generateEntreesPDF(){
  this._router.navigateByUrl("");
  }


}
