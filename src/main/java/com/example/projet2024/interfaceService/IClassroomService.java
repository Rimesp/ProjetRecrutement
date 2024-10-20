package com.example.projet2024.interfaceService;


import com.example.projet2024.entite.Classroom;

import java.util.Date;
import java.util.List;

public interface IClassroomService {


    List<Classroom> retrieveAllClassroom();

    Classroom  addClassroom(Classroom  classroom);

    Classroom updateClassroom(Classroom classroom);

    Classroom retrieveClassroom(Long numClassroom);

    //Offer updateOffer(Offer offer);
    void deleteClassroom(Long id);



    List<Classroom> showClassesToAdmin();

    List<Date> getFreeAppointementsByClassroom(Long classRoomId);


    List<Date> getAllFree();

}
