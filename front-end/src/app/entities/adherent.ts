import { Serv } from './serv';
import { Adresse } from './adresse';
import { Communaute } from './communaute';
import { BureauVote } from './bureau-vote';
import { Profession } from './profession';
export class Adherent {

  private  _adresse:Adresse=new Adresse();
  private _communaute:Communaute;
  private _bureauVote:BureauVote;
  private _profession:Profession;
  private _service:Serv;
  constructor(private _id_adherent ?: Number,
        private _nom_adherent ?: string,
        private _prenom_adherent ?: string,
        private _cin ?:string,
        private _dateDeNaissance ?: Date,
        private _lieuDeNaissance ?: string,
        private _dateAdhesion?:Date,
        private _numeroVote ?: Number,
        private _photo ?:string,
        private _motPasse?:string,
        private _sexe ?:string,
        private _telephone ?:string,
        private _email ?: string,
        private _role?:string
        ) {
          this._adresse=new Adresse();
          this._communaute=new Communaute();
          this._bureauVote=new BureauVote();
          this._profession=new Profession();
          this._service=new Serv();
        }
        get id_adherent() {
            return this._id_adherent;
        }

        get nom_adherent() {
            return this._nom_adherent;
        }
        set nom_adherent(value: string) {
            this._nom_adherent = value;
        }
        get prenom_adherent() {
            return this._prenom_adherent;
        }
        set prenom_adherent(value: string) {
            this._prenom_adherent = value;
        }
        get cin(){
            return this._cin;
        }
        set cin(value:string){
            this._cin=value;
        }
        get dateDeNaissance(){
            return this._dateDeNaissance;
        }
        set dateDeNaissance(value:Date){
            this._dateDeNaissance=value;
        }
        get lieuDeNaissance(){
            return this._lieuDeNaissance;
        }
        set lieuDeNaissance(value:string){
            this._lieuDeNaissance=value;
        }
        get dateAdhesion(){
          return this._dateAdhesion;
        }
        set dateAdhesion(value:Date){
          this._dateAdhesion=value;
        }
        get numeroVote(){
            return this._numeroVote;
        }
        set numeroVote(value:Number){
            this._numeroVote=value;
        }
        get photo(){
          return this._photo;
        }
        set photo(value:string){
          this._photo=value;
        }
        get motPasse(){
          return this._motPasse;
        }
        set motPasse(value:string){
          this._motPasse=value;
        }
        get sexe(){
          return  this._sexe;
        }
        set sexe(value:string){
          this._sexe=value;
        }
        get telephone(){
          return this._telephone;
        }
        set telephone(value:string){
          this._telephone=value;
        }
        get email(){
          return this._email;
        }
        set email(value:string){
          this._email=value;
        }
        get adresse():Adresse{
          return this._adresse;
        }
        set adresse(value:Adresse){
          this._adresse=value;
        }
        get bureauVote():BureauVote {
          this._bureauVote=new BureauVote();
          return this._bureauVote;
        }
        set bureauVote(value:BureauVote){
          this._bureauVote=value;
        }
        get commnuate():Communaute{
          return this._communaute;
        }
        set communaute(value:Communaute){
          this._communaute=value;
        }
        get profession():Profession{
          return this._profession;
        }
        set profession(value:Profession){
          this._profession=value;
        }
        get service():Serv{
       return this._service;
        }
        set service(value:Serv){
          this._service=value;
        }
        get role():string{
          return this._role;
        }
        set role(value:string){
         this._role=value;
        }

}
