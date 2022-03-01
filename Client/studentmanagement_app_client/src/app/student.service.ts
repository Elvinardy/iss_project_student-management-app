import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Student } from './student';

@Injectable()
export class StudentService {
  // stored the url in the environment.ts file
  private serverUrl = environment.apiBaseUrl;

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]> {
      return this.http.get<Student[]>(`${this.serverUrl}/student/all`);
  }

  public addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`${this.serverUrl}/student/add`, student);
}

  public updateStudent(student: Student): Observable<Student> {
  return this.http.put<Student>(`${this.serverUrl}/student/update`, student);
}

  public deleteStudent(studentId: number): Observable<void> {
  return this.http.delete<void>(`${this.serverUrl}/student/delete/${studentId}`);
}
}
