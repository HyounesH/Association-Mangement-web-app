import { BureauVote } from './../../../../entities/bureau-vote';
import { CommunauteService } from './../../../../services/communaute.service';
import { ProfessionService } from './../../../../services/profession.service';
import { AdherentService } from './../../../../services/adherent.service';
import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ExtraServiceService } from '../../../../services/extra-service.service';
import { Adherent } from '../../../../entities/adherent';
import { ServService } from '../../../../services/serv.service';
import { BureauVoteService } from '../../../../services/bureau-vote.service';
import { Serv } from '../../../../entities/serv';
import { Profession } from '../../../../entities/profession';
import { Communaute } from '../../../../entities/communaute';

@Component({
  selector: 'app-information-g',
  templateUrl: './information-g.component.html',
  styleUrls: ['./information-g.component.css']
})
export class InformationGComponent implements OnInit {
  public adherent:Adherent=new Adherent();

  public hidden:boolean=true;
  public adherentForm:FormGroup;
  private image:string;
  public _listServices:Serv[];
  public listBv:BureauVote[];
  public listProfession:Profession[];
  public listCommunaute:Communaute[];
  public profession_id:Number;
  public bureauVote_id:Number;
  public service_id:Number;
  public communaute_id:Number;
  constructor(private _router:Router,private _adherentService:AdherentService,private _extraService:ExtraServiceService,private _servService:ServService,private _bvService:BureauVoteService,private _professionService:ProfessionService,
    private _communauteService:CommunauteService) { }

  ngOnInit() {
    this.adherentForm=new FormGroup({
      "nom_adherent":new FormControl(this.adherent.nom_adherent,Validators.required),
      "prenom_adherent":new FormControl(this.adherent.prenom_adherent,Validators.required),
      "email":new FormControl(this.adherent.email,[Validators.required,Validators.pattern("^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,6}$")]),
      "motPasse":new FormControl(this.adherent.motPasse,[Validators.required,Validators.minLength(6)]),
      "cin":new FormControl(this.adherent.cin,Validators.required),
      "lieuDeNaissance":new FormControl(this.adherent.lieuDeNaissance,Validators.required),
      "telephone":new FormControl(this.adherent.telephone,[Validators.required,Validators.pattern("^0[567][0-9]{8}$")]),
      "dateDeNaissance":new FormControl(this.adherent.dateDeNaissance,Validators.required),
      "numeroVote":new FormControl(this.adherent.numeroVote,Validators.required),
      "role":new FormControl(this.adherent.role,Validators.required)
    });

    this._servService.getServices().subscribe((data)=>{
      console.log(data);
    this._listServices=data;
    },(error)=>{
     console.log(error);
    });
  this._bvService.getBureauVotes().subscribe((data)=>{
    console.log("bureau vote :"+data)
  this.listBv=data;
  },(error)=>{
  console.log(error);
  });
  this._professionService.getProfessions().subscribe((data)=>{
    console.log("profession : ",data);
    this.listProfession=data;
  },(error)=>{
  console.log(error);
  });
  this._communauteService.getCommunautes().subscribe((data)=>{
  console.log("communaute data : "+data);
  this.listCommunaute=data;
  },(error)=>{
  console.log(error);
  });

  this.communaute_id=this.listCommunaute[0].communaute_id;
  this.service_id=this._listServices[0].id_service;
  this.profession_id=this.listProfession[0].profession_id;
  this.bureauVote_id=this.listBv[0].bureauVote_id;

  }

  saveAdherent(){
  this.adherent.photo=this.image;
  this._adherentService.saveAdherent(this.adherent,this.profession_id,this.communaute_id,this.bureauVote_id,this.service_id,this.adherent.role).subscribe((data)=>{
      console.log(data);
      this._router.navigateByUrl("/assoc/membres/add/"+data.id_adherent+"/adresses");
    },(error)=>{
      console.log(error);
    });
  }

  get nom(){
    return this.adherentForm.get("nom_adherent");
  }
  get prenom(){
    return this.adherentForm.get("prenom_adherent");
  }
  get email(){
    return this.adherentForm.get("email");
  }
  get password(){
    return this.adherentForm.get("motPasse");
  }
  get cin(){
    return this.adherentForm.get("cin");
  }
  get lieuNaissance(){
    return this.adherentForm.get("lieuDeNaissance");
  }
  get phone(){
    return this.adherentForm.get("telephone");
  }
  get birthday(){
    return this.adherentForm.get("dateDeNaissance");
  }
  get voteNumber(){
    return this.adherentForm.get("numeroVote");
  }
  get role(){
    return this.adherentForm.get("role");
  }

  onFileSelected(event){
    let selectedFile:FileList;
    const file=event.target.files.item(0);
    if(file.type.match('image.*')){
      selectedFile=event.target.files;
    }
    else{
      alert("format invalid !");
    }
    this._extraService.pushFileToStorage(selectedFile.item(0)).subscribe((data)=>{
    console.log(data);
    console.log("name : "+ selectedFile.item(0).name);
    this.image=selectedFile.item(0).name;
    },(error)=>{
     console.log(error)
    });
    //selectedFile=undefined;
    }
}
