package position.Impl;

import position.DAO.PositionDAOImpl;
import position.Model.*;
import position.PositionService;

import javax.ws.rs.core.Response;
import java.util.List;

/**
 * Created by ueh093 on 5/5/15.
 */
public class PositionServiceImpl extends PositionDAOImpl implements PositionService {

    public PingResponse ping() {
        return new PingResponse("Pong pong!");
    }

    public TaskResponse post(Person person) {

        return new TaskResponse("Mission Compleated");

    }

    @Override
    public TaskResponse saveTrackPoint(TrackPoint trackPoint) {


        return new TaskResponse("Trackpoint was saved!");

    }

    @Override
    public TaskResponse saveTrackPoints(List<TrackPoint> trackPointList) {

        for (TrackPoint trackPoint : trackPointList){
            saveTrackPoint(trackPoint);
        }

        return new TaskResponse("Trackpointlist was saved!");
    }

    public Response savePerson(Person person) {

        String response = person.toString();
        return Response.status(200).entity(response).build();

    }

    public Response handlePosition(Position position) {

        if (savePosition(position))
            return Response.status(200).build();
        else
            return Response.status(400).build();
    }

    public Response insertPosition(Position position) {
        return handlePosition(position);
    }
}
