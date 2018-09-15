export class Adresse {

  constructor(private _quartier ?:string,
              private _ville ?:string,
              private _codePostal ?:string,
              private _pays ?:string,
              private _complAdresse?:string
   ) {
  }

  get quartier(){
    return this._quartier;
  }
  set quartier(value:string){
    this._quartier=value;
  }
  get ville(){
    return this._ville;
  }
  set ville(value:string){
    this._ville=value;
  }
  get codePostal(){
    return this._codePostal;
  }
  set codePostal(value:string){
  this._codePostal=value;
  }
  get pays(){
    return this._pays;
  }
  set pays(value:string){
    this._pays=value;
  }
  get complAdresse(){
    return this._complAdresse;
  }
  set complAdresse(value:string){
    this._complAdresse=value;
  }


}
