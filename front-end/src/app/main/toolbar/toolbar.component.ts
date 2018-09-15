import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-toolbar',
  templateUrl: './toolbar.component.html',
  styleUrls: ['./toolbar.component.css']
})
export class ToolbarComponent implements OnInit {
  public activeUsername:string="John Doe";
  constructor(private _router:Router) { }

  ngOnInit() {
    this.activeUsername=sessionStorage.getItem("login");
  }
  logout(){
   this._router.navigateByUrl('');
  }
}
