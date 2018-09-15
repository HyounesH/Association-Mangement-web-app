import { ReceveurDon } from './receveur-don';
import { Adherent } from "./adherent";
import { Donneur } from "./donneur";

export class Don {
  constructor(private _id_don?:Number,
              private _date_don?:Date,
              private _description_don?:string,
              private _type_don?:string,
              private _date_sortie?:Date,
              private _lieu_sortie?:string,
              private _montant?:Number,
              private _num_compte_banque?:Number,
              private _date_cheque?:Date,
              private _nom_banque?:string,
              private _etat?:string,
              private _suivi?:boolean,
              private _nom_complet?:string,
              private _role?:string,
              private _receveur_don?:ReceveurDon,
              private _donneur?:Donneur
  ){
   this._donneur=new Donneur();
   this._receveur_don=new ReceveurDon();
  }

  get id_don(){
    return this._id_don;
  }
  set id_don(value:Number){
    this._id_don=value;
  }
  get date_don(){
    return this._date_don;
  }
  set date_don(value:Date){
    this._date_don=value;
  }
  get description_don(){
    return this._description_don;
  }
  set description_don(value:string){
    this._description_don=value;
  }
  get type_don(){
    return this._type_don;
  }
  set type_don(value:string){
    this._type_don=value;
  }
  get dateSortie(){
    return this._date_sortie;
  }
  set dateSortie(value:Date){
    this._date_sortie=value;
  }
  get lieuSortie(){
    return this._lieu_sortie;
  }
  set lieuSortie(value:string){
   this._lieu_sortie=value;
  }
  get montant(){
    return this._montant;
  }
  set montant(value:Number){
    this._montant=value;
  }
  get num_compte_banque(){
    return this._num_compte_banque;
  }
  set num_compte_banque(value:Number){
    this._num_compte_banque=value;
  }
  get date_cheque(){
    return this._date_cheque;
  }
  set date_cheque(value:Date){
    this._date_cheque=value;
  }
  get nom_banque(){
    return this._nom_banque;
  }
  set nom_banque(value:string){
    this._nom_banque=value;
  }
  get etat(){
    return this._etat;
  }
  set etat(value:string){
    this._etat=value;
  }
  get suivi():boolean{
    return this._suivi;
  }
  set suivi(value:boolean){
    this._suivi=value;
  }
  get receveur_don(){
    return this._receveur_don;
  }
  set receveur_don(value:ReceveurDon){
    this._receveur_don=value;
  }
  get donneur(){
    return this._donneur;
  }
  set donneur(value:Donneur){
    this._donneur=value;
  }
  get nomComplet(){
    return this._nom_complet;
  }
  set nomComplet(value:string){
    this._nom_complet=value;
  }
  get role(){
    return this._role;
  }
  set role(value:string){
    this._role=value;
  }
}
