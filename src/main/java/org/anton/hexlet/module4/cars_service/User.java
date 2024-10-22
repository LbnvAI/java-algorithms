package org.anton.hexlet.module4.cars_service;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class User {
    @Setter
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private List<Long> personalCars = new ArrayList<>();

    public User(String firstName, String lastName, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
    }

    public void setCarId(Long carId) {
        personalCars.add(carId);
    }
}
