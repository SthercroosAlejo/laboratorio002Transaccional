package com.laboratorio.laboratorio_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

// handler de la API
@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
	private ParkingService parkingService;

    //Get cars

    //Get car by license plate

    //Get car by color

    //Post car

    //Deleted car by license plate

    //Post entry time

    //Post exit time
}
