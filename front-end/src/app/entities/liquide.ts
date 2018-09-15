

export class Liquide {
    constructor(private _id_liquide?:Number,
                private _date_depense?:Date,
                private _montant?:Number,
                private _type_depense?:string
    ){}


  get id_liquide(){
      return this._id_liquide;
  }

  set id_liquide(value:Number){
      this._id_liquide = value;
  }

  get date_depense(){
      return this._date_depense;
  }

  set date_depense(value:Date){
      this._date_depense = value;
  }

  get montant(){
      return this._montant;
  }

  set montant(value:Number){
      this._montant = value;
  }

  get type_depense(){
      return this._type_depense;
  }

  set type_depense(value:string){
      this._type_depense = value;
  }

  }
