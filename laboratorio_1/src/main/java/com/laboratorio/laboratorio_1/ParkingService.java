package com.laboratorio.laboratorio_1;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//Logica del negocio
@Service
public class ParkingService {
    private List<Car>parkingLot;
    private static final double HourlyRate = 2.5;

    public ParkingService() {
        this.parkingLot = new ArrayList<>();
    }

    public List<Car> getAllCars() {
        return this.parkingLot;
    }

    public Optional<Car> getCarByLicensePlate(String licensePlate) {
        return this.parkingLot.stream().filter(car -> car.getLicensePlate().equals(licensePlate)).findFirst();
    }

    public List<Car> getCarsByColor(String color) {
        return this.parkingLot.stream().filter(car -> car.getColor().equalsIgnoreCase(color)).collect(Collectors.toList());
    }

    public void addCar(Car car) {
        this.parkingLot.add(car);
    }

    public boolean removeCarByLicensePlate(String licensePlate) {
        return this.parkingLot.removeIf(car -> car.getLicensePlate().equals(licensePlate));
    }

    public void parkCar(Car car) {
        Optional<Car> optionalCar = getCarByLicensePlate(car.getLicensePlate());
        if(optionalCar.isPresent()){
            optionalCar.get().setEntryTime(LocalDateTime.now());
        }
        // car.setEntryTime(LocalDateTime.now());
        // addCar(car);
    }

    public void unparkCar(String licensePlate) {
        Optional<Car> optionalCar = getCarByLicensePlate(licensePlate);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            LocalDateTime exitTime = LocalDateTime.now();
            car.setExitTime(exitTime);
            // removeCarByLicensePlate(licensePlate);
        }
    }

    public double calculateParkingFee(String licensePlate) {
        Optional<Car> optionalCar = getCarByLicensePlate(licensePlate);
        if (optionalCar.isPresent()) {
            Car car = optionalCar.get();
            LocalDateTime entryTime = car.getEntryTime();
            LocalDateTime exitTime = car.getExitTime();
            if (entryTime != null && exitTime != null) {
                Long hoursParked = ChronoUnit.HOURS.between(entryTime, exitTime);
                return hoursParked * HourlyRate;
            }
        }
        return 0;
    }
}
