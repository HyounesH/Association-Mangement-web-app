export class Communaute {

	constructor(private _communaute_id?:Number ,private _nom_communaute ?:string) {
	}

  get communaute_id():Number{
  return this._communaute_id;
  }
  set communaute_id(value:Number){
    this._communaute_id=value;
  }

  get nom_communaute(){
    return this._nom_communaute;
  }
  set nom_communaute(value:string){
    this._nom_communaute=value;
  }
}
