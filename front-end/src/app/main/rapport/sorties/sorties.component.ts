import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { DonService } from '../../../services/don.service';
import { LiquideService } from '../../../services/liquide.service';
import { Liquide } from '../../../entities/liquide';
import { Don } from '../../../entities/don';
import { Adherent } from '../../../entities/adherent';
import { Donneur } from '../../../entities/donneur';
import { AdherentService } from '../../../services/adherent.service';
import { AdresseService } from '../../../services/adresse.service';

@Component({
  selector: 'app-sorties',
  templateUrl: './sorties.component.html',
  styleUrls: ['./sorties.component.css']
})
export class SortiesComponent implements OnInit {
 public listMateriel:Don[];
 public listArgent:Liquide[];
 public don : Don = new Don();
 public adherent:Adherent;

 @ViewChild('closeModal') closeModal: ElementRef;
  constructor(private _serviceDon:DonService, private _serviceLiquide:LiquideService,private _adherentService:AdherentService,private _adresseService:AdresseService) { }

  ngOnInit() {
    this._serviceDon.getMaterielSortant().subscribe((data)=>{
      console.log(data);
      this.listMateriel=data;
      for(let i=0;i<data.length;i++){
        this._adherentService.getAdherent(data[i].receveur_don.code_employe).subscribe((response)=>{
          this.listMateriel[i].nomComplet=response.nom_adherent+" "+response.prenom_adherent;
          this.listMateriel[i].role=response.role;
        });
      }
    },(error)=>{
      console.log(error);
    });

    this._serviceLiquide.getLiquides().subscribe((data)=>{
      console.log(data);
      this.listArgent=data;
    },(error)=>{
      console.log(error);
    });

    this.don = new Don();
    this.don.donneur = new Donneur();
    this.adherent = new Adherent();
  }

  details(id_don:Number){
    this._serviceDon.getDon(id_don).subscribe((data)=>{
      console.log(data);
      this.don = data;
      this._adherentService.getAdherent(data.receveur_don.code_employe).subscribe((response)=>{
        this.adherent=response;
        });
      this._adresseService.getAdresseByAdherentId(data.receveur_don.code_employe).subscribe((adresse)=>{
          this.adherent.adresse=adresse;
          });

    },(error)=>{
      console.log(error);
    })
    this.closeModal.nativeElement.click();
  }
}

