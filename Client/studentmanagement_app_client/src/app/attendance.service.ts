import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Attendance } from './student';

@Injectable()
export class AttendanceService {

  // private serverUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

/* postAttendance(attendance: Attendance): Observable<Attendance> {
    return this.http.post<Attendance>(`/attendance`, attendance);
} */

postAttendance(attendance: Attendance): Promise<void> {
  return lastValueFrom(this.http.post<void>('/attendance', attendance));
}
}


