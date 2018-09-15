export class Departement {
constructor(private _id_depart?:number,
            private _nom?:string,
            private _note?:string,
            private _adresse?:string,
            private _telephone?:string){

}
get id_depart(){
  return this._id_depart;
}
get nom(){
  return this._nom;
}
set nom(value:string){
  this._nom=value;
}
get note(){
  return this._note;
}
set note(value:string){
  this._note=value;
}
get adresse(){
  return this._adresse;
}
set adresse(value:string){
  this._adresse=value;
}
get telephone(){
  return this._telephone;
}
set telephone(value:string){
  this._telephone=value;
}
}

