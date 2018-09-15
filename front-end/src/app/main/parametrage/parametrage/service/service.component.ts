import { Serv } from './../../../../entities/serv';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ServService } from '../../../../services/serv.service';
import { ViewChild, ElementRef} from '@angular/core';
@Component({
  selector: 'app-service',
  templateUrl: './service.component.html',
  styleUrls: ['./service.component.css']
})
export class ServiceComponent implements OnInit {
  @ViewChild('closeModal') closeModal: ElementRef;
  @ViewChild('addService') addService:ElementRef;
  public serviceList:Serv[];
  private _serviceToDelete:Serv;
  public status_service:string;
  public status:string;
  public service:Serv=new Serv();

  constructor(private _router:Router,private _servSevice:ServService) { }

  ngOnInit() {
    this._servSevice.getServices().subscribe((services)=>{
      this.serviceList=services;
     },(error)=>{
       console.log(error);
     });
     this.status_service="Nouveau Service";
     this.status="Enregistrer";
  }

  deleteService(){
    this._servSevice.deleteService(this._serviceToDelete.id_service).subscribe((data)=>{
     console.log(data);
     this.serviceList.slice(this.serviceList.indexOf(this._serviceToDelete,1));
    },(error)=>{
      console.log(error);
    });
    this.closeModal.nativeElement.click();
    window.location.reload();
    }
  serviceToDelete(service:Serv){
  this._serviceToDelete=new Serv();
  this._serviceToDelete=service;
  }

  updateSevice(_service:Serv){
    this.service=_service;
    this.status_service="Modifier Service";
    this.status="Modifier";
  }
  nouveauService(){
    this.service=new Serv();
    this.status_service="Nouveau Service";
    this.status="Enregistrer";
  }
  add(){
   this._servSevice.saveService(this.service).subscribe((data)=>{
    console.log(data);
   },(error)=>{
   console.log(error);
   });
 this.addService.nativeElement.click();
 window.location.reload();
  }
  update(){
    this._servSevice.updateService(this.service).subscribe((data)=>{
    },(error)=>{
      console.log(error);
    });
    this.addService.nativeElement.click();
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
