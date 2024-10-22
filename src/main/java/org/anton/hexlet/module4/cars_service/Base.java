package org.anton.hexlet.module4.cars_service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Base {
    public static String getInfo(String carNumber) {
        List<String> result = new ArrayList<>();
        CarDAO carDAO = new CarDAO();
        try {
            carDAO.fillData(carNumber);
            result.add(carDAO.getCarID().toString());
            result.add(carDAO.getCarMade());
            result.add(carDAO.getCarModel());
            result.add(carDAO.getCarNumber());
            result.add(carDAO.getCarColor());
            result.add(carDAO.getOwnerId().toString());
            result.add(carDAO.getOwnerFirstName());
            result.add(carDAO.getOwnerLastName());
            result.add(carDAO.getOwnerAddress());
            return String.join(" ", result);
        } catch (SQLException e) {
            throw new NoSuchElementException("no car found");
        }
    }
}
