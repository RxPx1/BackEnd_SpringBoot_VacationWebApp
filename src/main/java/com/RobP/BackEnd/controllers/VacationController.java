package com.RobP.BackEnd.controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VacationController {

    @GetMapping("/vacation")
    public ResponseEntity<String> getVacation(){
        return ResponseEntity.ok("Vacation route");
    }

    @GetMapping("/vacation/{vacationId}")
    public ResponseEntity<String> getVacationById(@PathVariable String vacationId){
        return ResponseEntity.ok("VacationId route");
    }
}
