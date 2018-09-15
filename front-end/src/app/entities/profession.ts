export class Profession {

  constructor(private _profession_id?:Number,
              private _profession_nom ?:string,
              private _profession_note ?:string) {
	}

  get profession_id(){
    return this._profession_id;
  }
  set profession_id(value:Number){
   this._profession_id=value;
  }
  get prefession_nom(){
   return this._profession_nom;
  }
  set prefession_nom(value:string){
    this._profession_nom=value;
  }
  get profession_note(){
    return this._profession_note;
  }
  set profession_note(value:string){
    this._profession_note=value;
  }
}
