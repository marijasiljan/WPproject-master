package com.wp.project.beautysalon.web;

import com.wp.project.beautysalon.model.Appointment;
import com.wp.project.beautysalon.model.SalonService;
import com.wp.project.beautysalon.model.Termin;
import com.wp.project.beautysalon.model.User;
import com.wp.project.beautysalon.service.AppointmentService;
import com.wp.project.beautysalon.service.SalonServiceService;
import com.wp.project.beautysalon.service.TerminService;
import com.wp.project.beautysalon.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AppointmentController {

    private final AppointmentService appointmentService;
    private final SalonServiceService salonService;
    private final TerminService terminService;
    private final UserService userService;


    public AppointmentController(AppointmentService appointmentService, SalonServiceService salonService, TerminService terminService, UserService userService) {
        this.appointmentService = appointmentService;
        this.salonService = salonService;
        this.terminService = terminService;
        this.userService = userService;
    }


    @GetMapping("/appointmentList")
    public String showListAppointments(Model model) {
//        List<Termini> termini = this.terminiService.findAll();
//        List<Rezervacija> rezervacii= this.rezervacijaService.listAll();
//        List<Uslugi> uslugi = this.uslugiService.findAll();
//        List<RezervacijaUslugi> rezUslugi = this.rezervacijaUslugiService.listAll();
//
//        model.addAttribute("termini", termini);
//        model.addAttribute("rezervacii",rezervacii);
//        model.addAttribute("uslugi",uslugi);
//        model.addAttribute("rezUslugi", rezUslugi);

       // ------

        List<Termin> termins = this.terminService.findAll();
        List<Appointment> appointmentList = this.appointmentService.listAll();
        List<SalonService> salonServiceList = this.salonService.findAll();


        model.addAttribute("termins", termins);
        model.addAttribute("appointments", appointmentList);
        model.addAttribute("services", salonServiceList);


        return "appointmentsList.html";
    }

    @GetMapping( "/makeAppointment")
    public String MakeAppointment(Model model) {
//        List<Uslugi> uslugi = this.uslugiService.findAll();
//        List<Termini> termini = this.terminiService.findAll();
//        List<Klienti> klienti = this.klientiService.listAll();
        List<Appointment> appointmentList = this.appointmentService.listAll();
        List<Termin> termins = this.terminService.findAll();
        List<User> clients = this.userService.listClients();

        model.addAttribute("appointmentList", appointmentList);
        model.addAttribute("termins", termins);
        model.addAttribute("clients", clients);

        return "appointment.html";
    }


}
