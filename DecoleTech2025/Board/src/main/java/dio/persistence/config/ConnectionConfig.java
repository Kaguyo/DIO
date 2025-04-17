package dio.persistence.config;

import lombok.NoArgsConstructor;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {

    public static Connection getConnection() throws SQLException {
        Properties props = new Properties();

        try (InputStream input = ConnectionConfig.class
                .getClassLoader()
                .getResourceAsStream("application.properties")) {

            if (input == null) {
                throw new IOException("Arquivo application.properties não encontrado.");
            }

            props.load(input);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar configurações do banco de dados", e);
        }

        String fullUrl = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        String dbName = fullUrl.substring(fullUrl.lastIndexOf("/") + 1).split("\\?")[0];
        String baseUrl = fullUrl.substring(0, fullUrl.lastIndexOf("/"));
        String[] splitUrl = fullUrl.split("\\?", 2);

        String connectionParams = (splitUrl.length > 1) ? "?" + splitUrl[1] : "";

        try (Connection conn = DriverManager.getConnection(baseUrl + connectionParams, user, password);
            Statement stmt = conn.createStatement()) {
            stmt.executeUpdate("CREATE DATABASE IF NOT EXISTS `" + dbName + "`");
        }

        Connection connection = DriverManager.getConnection(baseUrl + "/" + dbName + connectionParams, user, password);
        connection.setAutoCommit(false);
        
        return connection;
    }
}