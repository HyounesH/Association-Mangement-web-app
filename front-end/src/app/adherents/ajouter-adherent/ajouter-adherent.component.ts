import { Adherent } from './../../entities/adherent';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-ajouter-adherent',
  templateUrl: './ajouter-adherent.component.html',
  styleUrls: ['./ajouter-adherent.component.css']
})
export class AjouterAdherentComponent implements OnInit {
  public adherent:Adherent=new Adherent();
  constructor() { }

  ngOnInit() {
  }

}
