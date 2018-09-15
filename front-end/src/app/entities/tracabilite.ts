export class Tracabilite {

  constructor(
    private  _idTracabilite?:Number,
    private _date_envoi?:string,
    private _description?:string,
    private _lieu_envoi?:string
  ){
  }
  get idTracabilite(){
    return this._idTracabilite;
  }
  set idTracabilite(value:Number){
    this._idTracabilite=value;
  }
  get date_envoi(){
    return this._date_envoi;
  }
  set date_envoi(value:string){
   this._date_envoi=value;
  }
  get description(){
   return this._description;
  }
  set description(value:string){
    this._description=value;
  }
  get lieu_envoi(){
    return this._lieu_envoi;
  }
  set lieu_envoi(value:string){
    this._lieu_envoi=value;
  }
}
