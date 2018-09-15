export class TypeAction {

  constructor(private _typeAction_id ?:Number,
              private _typeAction_nom?:string,
              private _typeAction_note?:string){}

  get typeAction_id(){
    return this._typeAction_id;
  }
  set typeAction_id(value:Number){
    this._typeAction_id=value;
  }
  get typeAction_nom(){
    return this._typeAction_nom;
  }
  set typeAction_nom(value:string){
    this._typeAction_nom=value;
  }
  get typeAction_note(){
    return this._typeAction_note;
  }
  set typeAction_note(value:string){
    this._typeAction_note=value;
  }
}


