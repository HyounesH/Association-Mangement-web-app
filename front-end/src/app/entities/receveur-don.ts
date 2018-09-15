export class ReceveurDon {
  constructor(private _id_receveur_don?:Number,
             private _code_employe?:Number){}


             get id_receveur_don(){
               return this._id_receveur_don;
             }
             set id_receveur_don(value:Number){
              this._id_receveur_don=value;
             }
             get code_employe(){
               return this._code_employe;
             }
             set code_employe(value:Number){
               this._code_employe=value;
             }
}
