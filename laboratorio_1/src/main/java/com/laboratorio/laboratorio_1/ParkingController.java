package com.laboratorio.laboratorio_1;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

// handler de la API
@RestController
@RequestMapping("/parking")
public class ParkingController {

    @Autowired
	private ParkingService parkingService;

    //Get cars
    @GetMapping("/cars")
	public ResponseEntity<List<Car>> getAllCars(){
		return ResponseEntity.ok(this.parkingService.getAllCars());
	}

    //Get car by license plate
	@GetMapping("/cars/{licensePlate}")
	public ResponseEntity<Car> getCarByLicensePlate(@PathVariable String licensePlate){
		Optional<Car> optinalCar = this.parkingService.getCarByLicensePlate(licensePlate);
		if(optinalCar.isPresent()){
			return ResponseEntity.ok(optinalCar.get());
		}
		return ResponseEntity.notFound().build();
	}

    //Get car by color

    //Post car

    //Deleted car by license plate

    //Post entry time

    //Post exit time
}
