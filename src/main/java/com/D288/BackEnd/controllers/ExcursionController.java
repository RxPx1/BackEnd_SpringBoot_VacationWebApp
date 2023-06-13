package com.D288.BackEnd.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExcursionController {

   @GetMapping("/excursion")
    public ResponseEntity<String> getExcursion(){
       return ResponseEntity.ok("Excursion route");
   }

   @GetMapping("/excursion/{excursionId}")
    public ResponseEntity<String> getExcursionById(@PathVariable String excursionId){
       return ResponseEntity.ok("ExcursionId route");
   }
}
