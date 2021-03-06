import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from '../model/product';
@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private productUrl = 'https://steventest.condoresource.ca/api/product/all';
  //private productUrl = 'http://localhost:8080/api/product/all';

  constructor(private http : HttpClient) {  }

  public getProducts() : Observable<Product[]>{
    return this.http.get<any>(this.productUrl);
  }
}
