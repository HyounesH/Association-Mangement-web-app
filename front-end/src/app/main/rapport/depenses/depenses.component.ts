import { Component, OnInit, ElementRef, ViewChild } from '@angular/core';
import { LiquideService } from '../../../services/liquide.service';
import { Liquide } from '../../../entities/liquide';
import { FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-depenses',
  templateUrl: './depenses.component.html',
  styleUrls: ['./depenses.component.css']
})
export class DepensesComponent implements OnInit {
  public liquide:Liquide = new Liquide();
  public liquides:Liquide[];
  public liquidToDelete:Liquide;
  public id:Number;
  public depenseForm:FormGroup

  @ViewChild('closeModalModif') closeModalModif : ElementRef;
  @ViewChild('closeModal') closeModal : ElementRef;
  constructor(private _serviceLiquide : LiquideService) { }

  ngOnInit() {
    this.depenseForm=new FormGroup({
     "date_depense":new FormControl(this.liquide.date_depense,Validators.required),
     "montant":new FormControl(this.liquide.montant,[Validators.required,Validators.pattern("^[0-9]+$")]),
     "type_depense":new FormControl(this.liquide.type_depense,Validators.required)
    });
    this._serviceLiquide.getLiquides().subscribe((data)=>{
      console.log(data);
      this.liquides=data;
    },(error)=>{
      console.log(error);
    });
  }

  addDepense(){
    this._serviceLiquide.saveLiquide(this.liquide).subscribe((data)=>{
      console.log(data);
      window.location.reload(); // pour recharger la liste des dépenses après l'ajout d'une nouvelle dépense
    },(error)=>{
      console.log(error);
    });
  }

  getDepense(liquide : Liquide){
    this.liquide = new Liquide();
    this.liquide = liquide;
  }

  deleteDepense(){
    console.log(this.liquide);
    this._serviceLiquide.deleteLiquide(this.liquide.id_liquide).subscribe((data)=>{
      console.log(data);
      this.liquides.slice(this.liquides.indexOf(this.liquide,1));
  },(error)=>{
    console.log(error);
  });
   this.closeModal.nativeElement.click();
   window.location.reload(); // recharger la liste des dépenses après la suppression d'une dépense
  }

  updateDepense(){
    console.log(this.liquide);
    this._serviceLiquide.updateLiquide(this.liquide).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
      this.closeModalModif.nativeElement.click();
      window.location.reload();
  }
  get depense_date(){
    return this.depenseForm.get("date_depense");
  }
  get depense_montant(){
    return this.depenseForm.get("montant");
  }
  get depense_type(){
    return this.depenseForm.get("type_depense");
  }

}

