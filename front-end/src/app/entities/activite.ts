export class Activite {
  constructor(private _action_id?:Number,
             private _action_nom?:string,
             private _lieu?:string,
             private _dateCreation?:Date,
             private _dateRealise?:Date,
             private _objectif?:string ){}


  get action_id(){
    return this._action_id;
  }
  get action_nom(){
    return this._action_nom;
  }
  set action_nom(value:string){
    this._action_nom=value;
  }
  get lieu(){
    return this._lieu;
  }
  set lieu(value:string){
    this._lieu=value;
  }
  get dateCreation(){
    return this._dateCreation;
  }
  set dateCreation(value:Date){
    this._dateCreation=value;
  }
  get dateRealise(){
    return this._dateRealise;
  }
  set dateRealise(value:Date){
    this._dateRealise=value;
  }
  get objectif(){
    return this._objectif;
  }
  set objectif(value:string){
    this._objectif=value;
  }
}
