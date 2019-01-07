import { Component, OnInit } from '@angular/core';
import { BearService } from '../services/bear.service';
import {Bear} from '../models/bear.model'

@Component({
  selector: 'app-bear',
  templateUrl: './bear.component.html',
  styleUrls: ['./bear.component.css']
})
export class BearComponent implements OnInit {

  private bears: Bear[];

  //inject service by providing it as a constructor argument
  constructor(private bearService: BearService) {}

  //for property binding
  public objectStyle = {
    color: 'red',
    border: '1px solid black',
    cursor: 'pointer',
    margin: '2px'
  }

    //for two-way databinding
    public twoWayValue: string = '';

  public changeStyles(): void {
    if (this.objectStyle.color === 'red') {
      this.objectStyle.color = 'blue';
      this.objectStyle.border = '4px groove purple';
    } else if (this.objectStyle.color === 'blue') {
      this.objectStyle.color = 'green';
      this.objectStyle.border = '4px ridge yellow';
    } else if (this.objectStyle.color === 'green') {
      this.objectStyle.color = 'red';
      this.objectStyle.border = '4px solid black';
    }
  }

  ngOnInit() {
    this.bears = this.bearService.getBears();
    console.log(this.bears);
  }

}
