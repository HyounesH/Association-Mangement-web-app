export class Fonction {
  constructor(private _focntion_id?:Number,
             private _fonction_nom?:string,
             private _fonction_note?:string,
             private _dateDebut?:Date,
             private _dateFin?:Date
           ){}

  get fonction_id(){
    return this._focntion_id;
  }
  get fonction_nom(){
    return this._fonction_nom;
  }
  set fonction_nom(value:string){
    this._fonction_nom=value;
  }
  get fonction_note(){
    return this._fonction_note;
  }
  set fonction_note(value:string){
    this._fonction_note=value;
  }
  get dateDebut(){
    return this._dateDebut;
  }
  set dateDebut(value:Date){
    this._dateDebut=value;
  }
  get dateFin(){
    return this._dateFin;
  }
  set dateFin(value:Date){
    this._dateFin=value;
  }
}
