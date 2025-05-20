package Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConfig {
    private static final String URL = "jdbc:mysql://localhost:3306/desarrolloweb";
    private static final String USER ="root";
    private static final String PASSWORD = "123456";
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    //Metdodo para obtener la conexión a la base de datos
    public static Connection getConnection() throws SQLException {
        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new SQLException("Error al cargar el driver no ha sido encontrado: " + e.getMessage());
        } catch (SQLException e) {
            e.printStackTrace();
            var message = "Error al conectar a la base de datos: " + e.getMessage();
            throw new SQLException(message);
        }
        return connection;
    }
}