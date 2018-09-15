import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { StructureService } from '../../../../services/structure.service';
import { ViewChild, ElementRef} from '@angular/core';
import { Structure } from '../../../../entities/structure';

@Component({
  selector: 'app-structure',
  templateUrl: './structure.component.html',
  styleUrls: ['./structure.component.css']
})
export class StructureComponent implements OnInit {
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addstructure') addStructure:ElementRef;
  public structureList:Structure[];
  private _structureToDelete:Structure;
  public status_structure:string;
  public status:string;
  public structureToAdd:Structure=new Structure();
  constructor(private _router:Router,private _serviceStructure:StructureService) { }

  ngOnInit() {
    this._serviceStructure.getStructures().subscribe((structures)=>{
      console.log(structures);
      this.structureList=structures;
     },(error)=>{
       console.log(error);
     });
     this.status_structure="Nouvelle Structure";
     this.status="Enregistrer";
  }
  deleteStructure(){
    console.log(this._structureToDelete);
    this._serviceStructure.deleteStructure(this._structureToDelete.id_structure).subscribe((data)=>{
      console.log(data);
      this.structureList.slice(this.structureList.indexOf(this._structureToDelete,1));
     },(error)=>{
       console.log(error);
     });
     this.closeModal.nativeElement.click();
     window.location.reload();
  }

  structureToDelete(structure:Structure){
    this._structureToDelete=new Structure();
    this._structureToDelete=structure;
  }

  updateStructure(_structure:Structure){
    this.structureToAdd=_structure;
    this.status_structure="Modifier la Structure";
    this.status="Modifier";
  }
  nouveauStructure(){
    this.structureToAdd=new Structure();
    this.status_structure="Nouvelle structure";
    this.status="Enregistrer";
  }
  add(){
   this._serviceStructure.saveStructure(this.structureToAdd).subscribe((data)=>{
    console.log(data);
   },(error)=>{
   console.log(error);
   });
  this.addStructure.nativeElement.click();
   window.location.reload();
  }

  update(){
    this._serviceStructure.updateStructure(this.structureToAdd).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
  this.addStructure.nativeElement.click();
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
