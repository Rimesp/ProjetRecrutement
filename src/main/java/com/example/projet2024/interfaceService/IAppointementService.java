package com.example.projet2024.interfaceService;

import com.example.projet2024.entite.Appointment;

import java.util.Date;
import java.util.List;

public interface IAppointementService {

    List<Appointment> retrieveAllAppointement();

    Appointment  addappointement(Appointment  appointement);

    Appointment updateappointement(Appointment appointement);

    Appointment retrieveappointement(Long numAppointement);

    List<Appointment> retrieveappointement(Long sender, Long reciever);
    void deleteappointement(Long id);
     List<Appointment> getAppointmentsForClassroomAndTime(Long classroomId, Date startTime, Date endTime) ;

}
