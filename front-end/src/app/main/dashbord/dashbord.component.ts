import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AdherentService } from '../../services/adherent.service';
import { DonService } from '../../services/don.service';

@Component({
  selector: 'app-dashbord',
  templateUrl: './dashbord.component.html',
  styleUrls: ['./dashbord.component.css']
})
export class DashbordComponent implements OnInit {
  public activeUsername:string="John Doe";
  public nbreAdherent:number;
  public  nbreDon:number;
  constructor(private _AdherentService:AdherentService , private _DonService:DonService, private _router:Router) { }

  ngOnInit() {
    //extraire juste le prénom de l'utilisateur pour lui afficher un message de bienvenue.
    this.activeUsername = sessionStorage.getItem("login").split(" ")[1].charAt(0).toUpperCase()+sessionStorage.getItem("login").split(" ")[1].slice(1);

    // récupérer le nombre total des adhérents
    this._AdherentService.countAdherent().subscribe((nombre)=>{
      console.log(nombre);
      this.nbreAdherent = nombre;
      console.log(this.nbreAdherent);
    },(error)=>{
      console.log(error);
    });

    //récupérer le nombre total des dons
    this._DonService.countDon().subscribe((nombreDon)=>{
      console.log(nombreDon);
      this.nbreDon = nombreDon;
      console.log(this.nbreDon);
    },(error)=>{
      console.log(error);
    });
    }


  }

