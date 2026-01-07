package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class DBContext {

    protected Connection c;

    public DBContext() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            String url = System.getenv("DB_URL");
            String user = System.getenv("DB_USERNAME");
            String pass = System.getenv("DB_PASSWORD");

            if (url == null || user == null || pass == null) {
                Properties prop = new Properties();
                InputStream is = getClass()
                        .getClassLoader()
                        .getResourceAsStream("db.properties");

                if (is == null) {
                    throw new RuntimeException("db.properties not found in classpath");
                }

                prop.load(is);
                url = prop.getProperty("db.url");
                user = prop.getProperty("db.username");
                pass = prop.getProperty("db.password");
            }

            c = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            throw new RuntimeException("Cannot connect to database", e);
        }
    }

    public Connection getConnection() {
        return c;
    }
}
