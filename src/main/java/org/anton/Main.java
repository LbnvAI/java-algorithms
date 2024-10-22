package org.anton;

import org.anton.hexlet.module4.cars_users.Base;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        System.out.println(Base.getInfo("435f"));
    }
}