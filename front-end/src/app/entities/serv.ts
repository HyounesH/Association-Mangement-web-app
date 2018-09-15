export class Serv {
  private _service_sup:Serv;
  constructor(private _id_service?:number,
              private _nom?:string,
              private _adresse?:string){}

  get id_service(){
    return this._id_service;
   }
  set id_service(value:number){
    this._id_service=value;
  }
  get nom(){
    return  this._nom;
  }
  set nom(value:string){
    this._nom=value;
  }
  get adresse(){
    return this._adresse;
  }
  set adresse(value:string){
    this._adresse=value;
  }
  get service_sup(){
    return this._service_sup;
  }
  set service_sup(value:Serv){
  this._service_sup=new Serv();
  this._service_sup=value;
  }
}
