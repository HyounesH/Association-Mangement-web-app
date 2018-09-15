
export class Structure {

  private _structure_sup:Structure;
  constructor(private _id_structure?:Number,
              private _nom?:string,
              private _dateCreation?:Date,
              private _email?:string,
              private _siteWeb?:string,
              private _objectif?:string,
              private _logo?:string,
              private _adresse?:string,
              private _telephone?:string){}
  get id_structure(){
    return this._id_structure;
  }
  set id_structure(value:Number){
    this._id_structure=value;
  }
  get nom(){
    return this._nom;
  }
  set nom(value:string){
    this._nom=value;
  }
  get dateCreation(){
    return this._dateCreation;
  }
  set dateCreation(value:Date){
    this._dateCreation=value;
  }
  get email(){
    return this._email;
  }
  get siteWeb(){
    return this._siteWeb;
  }
  set siteWeb(value:string){
    this._siteWeb=value;
  }
  get objectif(){
    return this._objectif;
  }
  set objectif(value:string){
    this._objectif=value;
  }
  get logo(){
    return this._logo;
  }
  set logo(value:string){
    this._logo=value;
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
  get structure_sup():Structure{
    return this.structure_sup;
  }
  set structure_sup(value:Structure){
  this._structure_sup=value;
  }

}
