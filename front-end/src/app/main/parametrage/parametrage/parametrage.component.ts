import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';


@Component({
  selector: 'app-parametrage',
  templateUrl: './parametrage.component.html',
  styleUrls: ['./parametrage.component.css']
})
export class ParametrageComponent implements OnInit {

  constructor(private _router:Router) { }

  ngOnInit() {
  }
  structure(){
  this._router.navigate(['parametrage'])
  }

}
