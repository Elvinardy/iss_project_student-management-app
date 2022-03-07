import { HttpEvent, HttpHandler, HttpInterceptor, HttpRequest } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';
import { from, lastValueFrom, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthInterceptorService implements HttpInterceptor {

  constructor(private oktaAuth: OktaAuthService) { }

  intercept(request: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
    return from(this.handleAccess(request, next));
  }

  private async handleAccess(request: HttpRequest<any>, next: HttpHandler): Promise<HttpEvent<any>> {
    // only add an access token for secured endpoints
    const securedEndpoints = ['/student/'];

    if(securedEndpoints.some(url => request.urlWithParams.includes(url))) {
      // to get access token
      const accessToken = await this.oktaAuth.getAccessToken();
      // call for an asynchronous method

      //clone the request and add a new header with acess token
      request = request.clone({
        setHeaders: {
          Authorization: 'Bearer ' + accessToken
        }
      });
      console.log('>>> access token: ' + accessToken);
    }
    return await lastValueFrom(next.handle(request));
  }
}

