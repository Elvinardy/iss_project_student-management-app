package com.student_management_app.repository;

import com.student_management_app.model.Attendance;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<Attendance, Long>{

    
/*    @Autowired
    private JdbcTemplate template;

    public static final String SQL_ADD_ATTENDANCE = 
	"insert into attendance(date, atd_info, student_code) values (?, ?, ?)";

    public void insertAttendance(Attendance attendance, Student student) {
        template.update(SQL_ADD_ATTENDANCE, attendance.getDate(),
        attendance.getAtdInfo().toString(), student.getStudentCode());
    } */
}
