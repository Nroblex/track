package position.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by ueh093 on 5/7/15.
 */
public class ConnectionManager {

    private static Connection myConnection = null;

    public static Connection getConnected () {

        try {

            if (myConnection != null){
                return myConnection;
            }

            Class.forName("com.mysql.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost/track?user=anders&password=selborn");

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

}
