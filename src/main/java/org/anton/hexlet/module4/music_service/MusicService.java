package org.anton.hexlet.module4.music_service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
public class MusicService {
    private static final String songsDataBaseURL = "jdbc:h2:mem:hexlet";

    public static void createCatalog() throws SQLException {
        Connection connection = DriverManager.getConnection(songsDataBaseURL);
        var sql1 = """
                    CREATE TABLE songs (
                    id bigint GENERATED ALWAYS AS IDENTITY,
                    title varchar(255),
                    singer_name varchar(255)
                )""";

        try (var pstmt = connection.prepareStatement(sql1)) {
            pstmt.executeUpdate();
        }
        var sql2 = """
                INSERT INTO songs (title, singer_name) VALUES
                ('Summer Without Internet', 'John Doe'),
                ('Starry Rain', 'Jane Smith'),
                ('City Under the Sole', 'Mike Johnson'),
                ('Blue Mood', 'Emily Davis'),
                ('You are Not Like That', 'Olivia Brown'),
                ('Heartbreaker', 'Sophia Miller'),
                ('Mazes', 'Liam Wilson'),
                ('Snow', 'Noah Taylor'),
                ('Slavic Sky', 'Isabella Anderson'),
                ('We Became Oceans', 'William Thomas'),
                ('They Are With Me', 'Emma Jackson'),
                ('Silver', 'Lucas White'),
                ('Winter in the Heart', 'Amelia Harris'),
                ('Sun of Monaco', 'Ethan Clark'),
                ('Nirvana', 'Ava Martin'),
                ('Black and White', 'Charlotte Lee'),
                ('Time-River', 'James Thompson'),
                ('Moscow Autumn', 'Oliver Martinez'),
                ('The Best Day', 'Mia Hernandez'),
                ('Dance', 'Benjamin Lopez')
                """;
        try (var pstmt = connection.prepareStatement(sql2)) {
            pstmt.executeUpdate();
        }
    }


    public static List<Song> getSongByTitle(String title) throws SQLException {
        Connection connection = DriverManager.getConnection(songsDataBaseURL);
        SongDAO dao = new SongDAO(connection);
        return dao.findSongsByTitle(title);
    }
}

