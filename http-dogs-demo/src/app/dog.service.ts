import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';


@Injectable({
  providedIn: 'root'
})
export class DogService {

  constructor(private http: HttpClient) { }

  getRandomDog(): Observable<any> {
    return this.http.get('https://dog.ceo/api/breeds/image/random');
  }
}
