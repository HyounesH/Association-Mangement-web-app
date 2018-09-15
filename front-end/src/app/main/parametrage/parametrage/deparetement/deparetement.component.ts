import { Departement } from './../../../../entities/departement';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { DepartementService } from '../../../../services/departement.service';
import { ViewChild, ElementRef} from '@angular/core';
@Component({
  selector: 'app-deparetement',
  templateUrl: './deparetement.component.html',
  styleUrls: ['./deparetement.component.css']
})
export class DeparetementComponent implements OnInit {
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addDepart') addDepart:ElementRef;
  private _departemenList:Departement[];
  private _departementToDelete:Departement;
  public status_departement:string;
  public status:string;
  public departement:Departement=new Departement();
  constructor(private _router:Router,private _departService:DepartementService) {}

  ngOnInit() {
    this._departService.getDeparts().subscribe((departements)=>{
      console.log(departements);
      this._departemenList=departements;
     },(error)=>{
       console.log(error);
     });
     this.status_departement="Nouveau Departement";
     this.status="Enregistrer";
  }
  get departementList(){
    return this._departemenList;
  }
  deleteDepartement(){
    this._departService.deleteDepart(this._departementToDelete.id_depart).subscribe((data)=>{
     console.log(data);
     this._departemenList.slice(this._departemenList.indexOf(this._departementToDelete,1));
    },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
    }
    departementToDelete(departement:Departement){
      this._departementToDelete=new Departement();
      this._departementToDelete=departement;
    }


  updateDepartement(_departement:Departement){
    this.departement=_departement;
    this.status_departement="Modifier Departement";
    this.status="Modifier";
  }
  nouveauDepartement(){
    this.departement=new Departement();
    this.status_departement="Nouveau Departement";
    this.status="Enregistrer";
  }
  add(){
     this._departService.saveDepart(this.departement).subscribe((data)=>{
      console.log(data);
     },(error)=>{
     console.log(error);
     });
    this.addDepart.nativeElement.click();
    window.location.reload();
    }

    public update(){
      this._departService.updateDepart(this.departement).subscribe((data)=>{
        console.log(data);
      },(error)=>{
        console.log(error);
      });
      this.addDepart.nativeElement.click();
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
