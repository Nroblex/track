package position.DAO;

import position.Model.Position;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created by ueh093 on 5/6/15.
 */
public abstract class PositionDAOImpl {

    private Connection connect = null;

    PreparedStatement pstmt = null;

    public Boolean savePosition(Position position) {

        try {
            Class.forName("com.mysql.jdbc.Driver");

            //connect = DriverManager.getConnection("jdbc:mysql://localhost/track?user=anders&password=selborn");

            String sql = "INSERT INTO pos(Latitude, Longitude, speed, altitude, heartrate, gpstime) values(?,?,?,?,?,?)";

            //pstmt = connect.prepareStatement(sql);
            pstmt = ConnectionManager.getConnected().prepareStatement(sql);

            pstmt.setDouble(1, position.getLatitude());
            pstmt.setDouble(2, position.getLongitude());
            pstmt.setInt(3, position.getSpeed());
            pstmt.setInt(4, position.getAltitude());
            pstmt.setInt(5, position.getHeartrate());
            pstmt.setTimestamp(6, new Timestamp(position.getGpstime()));

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;

    }


    public Boolean saveTrackPoint(){

        String sql = "INSERT INTO trackpoint(latitude, longitude) VALUES (?,?)";
        pstmt = ConnectionManager.getConnected().prepareStatement(sql);

        return true;
    }

    public void updatePosition(Position position) {

    }
}
