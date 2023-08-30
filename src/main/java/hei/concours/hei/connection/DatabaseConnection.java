package hei.concours.hei.connection;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Configuration
public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    public Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try{
                connection = DriverManager.getConnection(
                        DatabaseParams.url,
                        DatabaseParams.username,
                        DatabaseParams.password
                );
            }catch (SQLException e){
                throw new RuntimeException("Erreur de connexion à la base des données: ",e);
            }
        }
        return connection;
    }
    public static DatabaseConnection getInstance() {
        if (instance == null){
            instance = new DatabaseConnection();
        }
        return instance;
    }
}
