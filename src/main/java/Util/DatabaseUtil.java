package Util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseUtil {

    public static Connection getConnection() {
        try {
            String dburl="jdbc:mysql://localhost:3307/tutorial";
            String dbID="root";
            String dbPassword="kkjjss103@";
            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection(dburl,dbID,dbPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
