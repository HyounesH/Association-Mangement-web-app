export class Donneur {
    constructor(private _id_donneur?:Number,
                private _email?:string,
                private _telephone?:string,
                private _adresse?:string,
                private _ville?:string,
                private _pays?:string,
                private _nom_moral?:string,
                private _nom?:string,
                private _cin?:string,
                private _prenom?:string,
                private _type_donneur?:string,
                private _password?:string,
                private _role?:string,
                private _suivi?:boolean){}

    get id_donneur(){
      return this._id_donneur;
    }
    set id_donneur(value:Number){
      this._id_donneur=value;
    }
    get email(){
      return this._email;
    }
    set email(value:string){
      this._email=value;
    }
    get telephone(){
      return this._telephone;
    }
    set telephone(value:string){
      this._telephone=value;
    }
    get adresse(){
      return this._adresse;
    }
    set adresse(value:string){
      this._adresse=value;
    }
    get ville(){
      return this._ville;
    }
    set ville(value:string){
      this._ville=value;
    }
    get pays(){
      return this._pays;
    }
    set pays(value:string){
      this._pays=value;
    }
    get nom_moral(){
      return this._nom_moral;
    }
    set nom_moral(value:string){
      this._nom_moral=value;
    }
    get nom(){
      return this._nom;
    }
    set nom(value:string){
      this._nom=value;
    }
    get prenom(){
      return this._prenom;
    }
    set prenom(value:string){
      this._prenom=value;
    }
    get cin(){
      return this._cin;
    }
    set cin(value:string){
      this._cin=value;
    }
    get type_donneur(){
      return this._type_donneur;
    }
    set type_donneur(value:string){
      this._type_donneur=value;
    }
    get password(){
      return this._password;
    }
    set password(value:string){
    this._password=value;
    }
    get role(){
      return this._role;
    }
    set role(value:string){
      this._role=value;
    }
    get suivi(){
      return this._suivi;
    }
    set suivi(value:boolean){
      this._suivi=value;
    }
}
