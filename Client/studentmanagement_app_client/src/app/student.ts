export interface Student {
  id: number;
  name: string;
  email: string;
  classInfo: string;
  remarks: string;
  phone: string;
  imageUrl: string;
  studentCode: string;
}

export interface Attendance {
  date : number;
  atdInfo : number;
  id? : number;
}
