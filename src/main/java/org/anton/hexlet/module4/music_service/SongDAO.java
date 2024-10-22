package org.anton.hexlet.module4.music_service;

import lombok.Getter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class SongDAO {

    private Connection connection;
    public SongDAO (Connection connection) {
        this.connection = connection;
    }

    public List<Song> findSongsByTitle(String title) throws SQLException {
        List<Song> result = new ArrayList<>();
        var sql = "SELECT * FROM songs WHERE LOWER(title) LIKE LOWER(CONCAT('%',?,'%'))";
        try(var pstmt = connection.prepareStatement(sql)){
            pstmt.setString(1, title.toLowerCase());
            var rs = pstmt.executeQuery();
            while(rs.next()) {
                var id = rs.getLong("id");
                var fullTitle  = rs.getString("title");
                var artist = rs.getString("singer_name");
                var song = new Song(id,fullTitle,artist);
                result.add(song);
            }
            return result;
        }
        catch (SQLException e) {
            return result;
        }
    }
}
