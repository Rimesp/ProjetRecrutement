package com.example.projet2024.service;

import com.example.projet2024.entite.Appointment;
import com.example.projet2024.entite.Classroom;
import com.example.projet2024.interfaceService.IAppointementService;
import com.example.projet2024.interfaceService.IClassroomService;
import com.example.projet2024.repository.AppointmentRepo;
import com.example.projet2024.repository.ClassroomRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Service
public class AppointementService implements IAppointementService {
    @Autowired
    private AppointmentRepo appointementRepo;
    @Autowired
    private ClassroomRepo classroomRepo;
    @Autowired
    private IClassroomService classroomService;

     @Autowired
    private ClassroomService classroomServices;
    @Override
    public List<Appointment> retrieveAllAppointement() {
        return appointementRepo.findAll();
    }

    @Override
    public Appointment addappointement(Appointment appointement) {
        List<Classroom> classrooms = classroomRepo.findAll();

        for (Classroom myclass : classrooms) {
            List<Date> freeAppointements = classroomService.getFreeAppointementsByClassroom(myclass.getId());
            if (freeAppointements.contains(appointement.getStart())) {
                Date starting = appointement.getStart();
                Date ending = new Date(starting.getTime() + (30 * 60 * 1000)); // 30 minutes in milliseconds


                appointement.setEnd(ending);
                appointement.setClassroom(myclass);

                return appointementRepo.save(appointement);

            }
        }
        System.out.println("test1");
        return null;
    }

    @Override
    public Appointment updateappointement(Appointment appointement) {

        return appointementRepo.save(appointement);
    }

    @Override
    public Appointment retrieveappointement(Long numAppointement) {
        return appointementRepo.findById(numAppointement).orElse(null);
    }

    @Override
    public List<Appointment> retrieveappointement(Long sender, Long reciever) {

        // return appointementRepo.findAppointmentsBySenderAndReceiver(sender,reciever) ;
        return appointementRepo.findAll().stream().filter((ele) -> ele.getSender() == sender || ele.getReceiver() == reciever).toList();
    }

    @Override
    public void deleteappointement(Long id) {
        appointementRepo.deleteById(id);
    }

    //  @Override
    // public void deleteClassroom(int id) {

    //  classroomRepo.deleteById(id);
    //   appointementRepo.deleteById(id);
    // }
//---------------------------------------------Affectation ClasseRoom to Appointment -----------------------


    public void assignRandomClassroomToAppointment(Long appointmentId) {
        Appointment appointment = appointementRepo.findById(appointmentId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid appointment id: " + appointmentId));

        List<Classroom> classrooms = classroomRepo.findAll();
        if (classrooms.isEmpty()) {
            throw new IllegalStateException("No classrooms available.");
        }


        Random random = new Random();
        int randomIndex = random.nextInt(classrooms.size());
        Classroom randomClassroom = classrooms.get(randomIndex);

        appointment.setClassroom(randomClassroom);
        randomClassroom.getAppointements().add(appointment);
        //randomClassroom.getAppointments().add(appointment);

        appointementRepo.save(appointment);
        classroomRepo.save(randomClassroom);
    }

    public List<Appointment> getAppointmentsForClassroomAndTime(Long classroomId, Date startTime, Date endTime) {
        return appointementRepo.findAppointmentsByClassroomAndTimeInterval(classroomId, startTime, endTime);
    }

}