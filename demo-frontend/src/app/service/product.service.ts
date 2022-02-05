import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  //private productUrl = 'http://150.230.30.7/product/all';
  //private productUrl = 'http://150.230.30.7/api/ac/02';
  private productUrl = 'http://localhost:8080/product/all';

  constructor(private http : HttpClient) {  }

  public getProducts() : Observable<Product[]>{
    return this.http.get<any>(this.productUrl);
  }
}
