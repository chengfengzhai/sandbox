import { HTTP_INTERCEPTORS, HttpEvent } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { HttpInterceptor,HttpHandler, HttpRequest } from "@angular/common/http";
import { Observable } from "rxjs";

import { TokenStorageService } from "../service/token-storage.service";

const TOKEN_HEADER_KEY = 'Authorization';

@Injectable()
export class AuthInterceptor implements HttpInterceptor{

    constructor(private tokenService : TokenStorageService){}

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        let authReq = req;
        const token = this.tokenService.getToken();
        if(token != null){
            authReq = req.clone({headers: req.headers.set(TOKEN_HEADER_KEY, 'Bearer '+ token)});
            return next.handle(authReq);
        }else{
            return next.handle(req);
        }
    }

}

export const authInerceptorProviders = [
    {provide : HTTP_INTERCEPTORS, useClass : AuthInterceptor, multi: true}
];