package com.example.projet2024.controller;

import com.example.projet2024.entite.Appointment;
import com.example.projet2024.entite.Classroom;
import com.example.projet2024.service.AppointementService;
import com.example.projet2024.service.ClassroomService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;


@RestController
@RequestMapping("/api/AppointementAndClassrooms/")
@RequiredArgsConstructor
@CrossOrigin
public class AppointementManagement {
    @Autowired
    private final AppointementService appointementService;
    @Autowired
    private final ClassroomService classroomService;


    //----------------------Swager -------------------------------
    //  http://localhost:8095/swagger-ui/index.html#/
    //-----------------------------------------------------------

    //------------------------------------------------------------------
    //-------------------------Appointement CRUD ------------------------
//--------------------------------------------------------------------
    // @Operation(description = "Add appointement")
    @PostMapping("/add-appointement")
    public Appointment addappointement(@RequestBody Appointment appointement){
        System.out.println(appointement.toString());
        return  appointementService.addappointement(appointement);
    }

    @Operation(description = "Retrieve all free appointements")
    @GetMapping("/getFreeDatesPerClassroom/{classroomId}")
    public List<Date> getFreeDates(@PathVariable("classroomId") Long classroomId) {
        return classroomService.getFreeAppointementsByClassroom(classroomId);
    }

    @Operation(description = "Retrieve all Appointement")
    @GetMapping("/all_Appointement")
    public List<Appointment> getAllAppointement() {
        return appointementService.retrieveAllAppointement();
    }

    @Operation(description = "Retrieve all Classrooms")
    @GetMapping("/all_classrooms")
    public List<Classroom> getAllclasses() {
        return classroomService.showClassesToAdmin();
    }

    @Operation(description = "Update Appointement ")
    @PutMapping("/update_Appointement")
    public Appointment updateAppointement(@RequestBody Appointment appointement) {
        return appointementService.updateappointement(appointement);
    }

    @Operation(description = "Retrieve Appointement by Id")
    @GetMapping("/getAppointement/{id-Appointement}")
    public Appointment getById(@PathVariable("id-Appointement") Long numappointement) {
        return appointementService.retrieveappointement(numappointement);
    }

    @Operation(description = "Retrieve all Appointement for youser")
    @GetMapping("/all_Appointement_foryouser/{id}")
    public List<Appointment> getAllAppointementforUser(@PathVariable("id") Long id) {
        return appointementService.retrieveappointement(id, id);

    }

    @DeleteMapping("/deleteAppointement/{idAppointement}")
    public void deleteAppointement(@PathVariable("idAppointement") Long id) {
        appointementService.deleteappointement(id);
    }


    //--------------------------------------------------------------
//--------------------- Classeroom CRUD ------------------------
//----------------------------------------------------------
    @PostMapping("/add_Classroom")
    public Classroom addClassroom(@RequestBody Classroom classroom) {
        return classroomService.addClassroom(classroom);
    }


    @Operation(description = "Retrieve all Classroom")
    @GetMapping("/all_Classroom")
    public List<Classroom> getAllClassroom() {
        return classroomService.retrieveAllClassroom();
    }

    @Operation(description = "Update Classroom ")
    @PutMapping("/update_Classroom")
    public Classroom updateClassroom(@RequestBody Classroom classroom) {
        return classroomService.updateClassroom(classroom);


    }

    @Operation(description = "Retrieve Classroom by Id")
    @GetMapping("/getClassroom/{id-Classroom}")
    public Classroom getClassroomById(@PathVariable("id-Classroom") Long numClassroom) {
        return classroomService.retrieveClassroom(numClassroom);
    }


    @DeleteMapping("/deleteClassroom/{idClassroom}")
    public void deleteClassroom(@PathVariable("idClassroom") Long id) {
        classroomService.deleteClassroom(id);
    }

    //---------------------------------------------Affectation ClasseRoom to Appointment -----------------------
    @Operation(description = "Retrieve freeAppointements by classroomId")
    @GetMapping("/getFreeAppointements/{id-Classroom}")
    public List<Date> getFreeApointements(@PathVariable("id-Classroom") Long numClassroom) {
        return classroomService.getFreeAppointementsByClassroom(numClassroom);
    }

    @GetMapping("/availableTime")
    public List<Date> getAvailableDate() {
        return classroomService.getAllFree();
    }
    @GetMapping("/appointments/timeInterval")
    public ResponseEntity<List<Appointment>> getAppointmentsForClassroomAndTime(
            @RequestParam("classroomId") Long classroomId,
            @RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {

        Date startDate = Date.from(start.atZone(ZoneId.systemDefault()).toInstant());
        Date endDate = Date.from(end.atZone(ZoneId.systemDefault()).toInstant());

        List<Appointment> appointments = appointementService.getAppointmentsForClassroomAndTime(classroomId, startDate, endDate);
        return ResponseEntity.ok(appointments);
    }
}