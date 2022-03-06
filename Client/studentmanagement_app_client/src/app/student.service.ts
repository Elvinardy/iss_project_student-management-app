import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { lastValueFrom, Observable } from 'rxjs';
import { environment } from 'src/environments/environment';
import { isConstructSignatureDeclaration } from 'typescript';
import { Attendance, Student } from './student';

@Injectable()
export class StudentService {
  // stored the url in the environment.ts file
/*   private serverUrl = environment.apiBaseUrl; */
student!: Student;
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

/* public getStudentId(id: number) {
  return this.studentSvc.getStudents(id)

}  */
postAttendance(attendance: Attendance): Promise<void> {
  return lastValueFrom(
    this.http.post<void>('student/attendance', attendance));
}

/* public postAttendanceWithId(): Observable<Attendance> {
  return this.http.post(`/student/attendance`)
    .map(response => response.json().data as Attendance)
    .flatMap((att : Attendance) => Observable.forkJoin(att.map((student : Student) => {
      return this.student.id
    })))
} */

}
