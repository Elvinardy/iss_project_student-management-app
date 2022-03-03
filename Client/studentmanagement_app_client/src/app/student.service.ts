import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { Student } from './student';

@Injectable()
export class StudentService {
  // stored the url in the environment.ts file
/*   private serverUrl = environment.apiBaseUrl; */

  constructor(private http: HttpClient) { }

  public getStudents(): Observable<Student[]> {
      return this.http.get<Student[]>(`/student/all`);
  }

  public addStudent(student: Student): Observable<Student> {
    return this.http.post<Student>(`/student/add`, student);
}

  public updateStudent(student: Student): Observable<Student> {
  return this.http.put<Student>(`/student/update`, student);
}

  public deleteStudent(studentId: number): Observable<void> {
  return this.http.delete<void>(`/student/delete/${studentId}`);
}
}
