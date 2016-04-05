package position.Model;

import org.codehaus.enunciate.json.JsonProperty;

/**
 * Created by ueh093 on 6/25/15.
 */
public class TrackPoint {

    private double latitude;
    private double longitude;
    private String trackguid;
    private Integer heartrate;
    private long timepoint;


    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTrackguid() {
        return trackguid;
    }

    public void setTrackguid(String trackguid) {
        this.trackguid = trackguid;
    }

    public Integer getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(Integer heartrate) {
        this.heartrate = heartrate;
    }


    public long getTimepoint() {
        return timepoint;
    }

    public void setTimepoint(long timepoint) {
        this.timepoint = timepoint;
    }
}
