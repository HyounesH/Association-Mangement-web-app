import { Telephone } from './telephone';
export class BureauVote {

  private _telephones:Telephone[];

  constructor(private _bureauVote_id?:Number,private _nom_bureauVote ?:string,
              private _adresse ?:string
  ) {
  }
  get bureauVote_id():Number{
    return  this._bureauVote_id;
  }
  set bureauVote_id(value:Number){
    this._bureauVote_id=value;
  }
  get nom_bureauVote(){
    return this._nom_bureauVote;
  }
  set nom_bureauVote(value:string){
    this._nom_bureauVote=value;
  }
  get adresse(){
    return this._adresse;
  }
  set adresse(value:string){
    this._adresse=value;
  }

  get telephones():Telephone[]{
    return this._telephones;
  }
  set telephones(value:Telephone[]){
    this._telephones=value;
  }
}
