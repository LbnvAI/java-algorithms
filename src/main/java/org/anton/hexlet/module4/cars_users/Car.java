package org.anton.hexlet.module4.cars_users;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Car {
    @Setter
    private Long id;
    private String made;
    private String model;
    private String number;
    private String color;
    private Long ownerId;

    public Car(String made, String model, String number, String color, String owner) {
        this.made = made;
        this.model = model;
        this.number = number;
        this.color = color;
    }

    public void setOwner(User user) {
        this.ownerId = user.getId();
        user.setCarId(this.id);
    }
}
