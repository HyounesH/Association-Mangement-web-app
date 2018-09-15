import { TypeActionService } from './../../../../services/type-action.service';
import { TypeAction } from './../../../../entities/type-action';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-type-action',
  templateUrl: './type-action.component.html',
  styleUrls: ['./type-action.component.css']
})
export class TypeActionComponent implements OnInit {
  public typeActionList:TypeAction[];
  private _typeActionToDelete:TypeAction;
  public status_typeAction:string;
  public status:string;
  public typeAction:TypeAction=new TypeAction();
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addTypeAction') addTypeAction:ElementRef;
   constructor(private _router:Router,private _typeActionService:TypeActionService) { }

   ngOnInit() {

     this._typeActionService.getTypeActions().subscribe((typeActions)=>{
      console.log(typeActions);
      this.typeActionList=typeActions;
     },(error)=>{
       console.log(error);
     });
     this.status_typeAction="Ajouter un nouveau type d'action(activité)";
     this.status="Enregistrer";
   }

   deleteTypeAction(){
   this._typeActionService.deleteTypeAction(this._typeActionToDelete.typeAction_id).subscribe((data)=>{
    console.log(data);
    this.typeActionList.slice(this.typeActionList.indexOf(this._typeActionToDelete,1));
   },(error)=>{
     console.log(error);
   });
   this.closeModal.nativeElement.click();
   window.location.reload();
   }

   typeActionToDelete(typeAction:TypeAction){
     this._typeActionToDelete=new TypeAction();
     this._typeActionToDelete=typeAction;
     console.log(this._typeActionToDelete);
   }

   updateTypeAction(_typeAction:TypeAction){
     this.typeAction=_typeAction;
     this.status_typeAction="Modifier un type d'action(activité)";
     this.status="Modifier";
   }
   nouveauTypeAction(){
     this.typeAction=new TypeAction();
     this.status_typeAction="ajouter un nouveau type d'action(activité) ";
     this.status="Enregistrer";
   }
   add(){
    console.log(this.typeAction);
    this._typeActionService.saveTypeAction(this.typeAction).subscribe((data)=>{
     console.log(data);
    },(error)=>{
    console.log(error);
    });
   this.addTypeAction.nativeElement.click();
   window.location.reload();
   }
   update(){
    this._typeActionService.updateTypeAction(this.typeAction).subscribe((data)=>{
      console.log(data);
    },(error)=>{
      console.log(error);
    });
    this.addTypeAction.nativeElement.click();
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
