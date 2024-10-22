package org.anton.hexlet.module4.cars_service;

import lombok.Getter;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

@Getter
public class CarDAO {
    // Car fields
    private Long carID;
    private String carMade;
    private String carModel;
    private String carNumber;
    private String carColor;
    // Owner fields
    private Long ownerId;
    private String ownerFirstName;
    private String ownerLastName;
    private String ownerAddress;

    public void fillData(String carNumber) throws SQLException {
        var connection = DriverManager.getConnection("jdbc:h2:mem:hexlet");
        var sql1 = "SELECT * FROM cars WHERE number = ?";
        try (var pstmt = connection.prepareStatement(sql1)) {
            pstmt.setString(1, carNumber);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                this.carID = rs.getLong("id");
                this.ownerId = rs.getLong("user_id");
                this.carMade = rs.getString("made");
                this.carModel = rs.getString("model");
                this.carNumber = carNumber;
                this.carColor = rs.getString("color");
            }
        }
        var sql2 = "SELECT * FROM users WHERE id = ?";
        try (var pstmt = connection.prepareStatement(sql2)) {
            pstmt.setLong(1, this.ownerId);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                this.ownerFirstName = rs.getString("first_name");
                this.ownerLastName = rs.getString("last_name");
                this.ownerAddress = rs.getString("address");
            }
            connection.close();
        }
    }
}