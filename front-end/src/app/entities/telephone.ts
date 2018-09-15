export class Telephone {

  constructor(private _telephone?:string,
              private _type ?:string) {
  }
  get telephone(){
  return  this._telephone;
  }
  set telephone(value:string){
    this._telephone=value;
  }
  get type(){
    return this._type;
  }
  set type(value:string){
    this._type=value;
  }

}

