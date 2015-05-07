package position.Model;

/**
 * Created by ueh093 on 5/6/15.
 */
public class Position {
    private double longitude;
    private double latitude;
    private int speed;
    private int altitude;
    private int heartrate;
    private long gpstime;

    public int getAltitude() {
        return altitude;
    }

    public void setAltitude(int altitude) {
        this.altitude = altitude;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Position() {
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public long getGpstime() {
        return gpstime;
    }

    public void setGpstime(long gpstime) {
        this.gpstime = gpstime;
    }

    @Override
    public String toString() {
        return "GPS: " + String.valueOf(this.getLongitude()) + ":" + String.valueOf(this.getLatitude());
    }
}
