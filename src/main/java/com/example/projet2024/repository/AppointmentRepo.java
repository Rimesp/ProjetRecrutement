package com.example.projet2024.repository;

import com.example.projet2024.entite.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment,Long> {
    @Query("SELECT a FROM Appointment a WHERE a.sender = :sender AND a.receiver = :receiver")
    List<Appointment> findAppointmentsBySenderAndReceiver(@Param("sender") Long sender, @Param("receiver") Long receiver);
    @Query("SELECT a FROM Appointment a WHERE a.classroom.id = :classroomId AND a.start >= :start AND a.end <= :end")
    List<Appointment> findAppointmentsByClassroomAndTimeInterval(
            @Param("classroomId") Long classroomId,
            @Param("start") Date start,
            @Param("end") Date end);

}
/*
package com.example.projet2024.repository;

import com.example.projet2024.entite.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepo  extends JpaRepository<Admin,Long> {
}
 */