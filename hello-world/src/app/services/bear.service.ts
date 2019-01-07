import {Bear} from '../models/bear.model'
import { Injectable } from '@angular/core';
import { Cave } from '../models/cave.model';
import { BearType } from '../models/bear-type.model';

@Injectable()
export class BearService {
    public getBears(): Bear[] {
        let bears: Array<Bear> = new Array<Bear>();
        let cave1: Cave = new Cave(7, 'Tampa', 6);
        let bearType1: BearType = new BearType(4, 'Grizzly');
        bears.push(new Bear(3, 'Betty', cave1, bearType1, 300, new Date()));
        bears.push(new Bear(4, 'Bob', cave1, bearType1, 400, new Date()));
        bears.push(new Bear(71, 'Gandalf', cave1, bearType1, 200, new Date()));
        return bears;
    }
}