package position.impl;

import java.sql.SQLException;
import java.util.List;

import javax.ws.rs.core.Response;

import position.DAO.PositionDAOImpl;
import position.Model.Person;
import position.Model.PingResponse;
import position.Model.Position;
import position.Model.TaskResponse;
import position.Model.TrackPoint;
import position.PositionService;

/**
 * Created by ueh093 on 2/25/16.
 */
public class PositionServiceImpl extends PositionDAOImpl implements PositionService {
    @Override
    public PingResponse ping() {
        return new PingResponse("Ping pong man!");
    }

    @Override
    public TaskResponse post(Person person) {
        return null;
    }

    @Override
    public Response saveTrackPoint(TrackPoint trackPoint) {
        if (doSaveTrackPoint(trackPoint)){
            return Response.status(200).build();
        }else{
            return Response.status(404).build();
        }
    }

    @Override
    public TaskResponse saveTrackPoints(List<TrackPoint> trackPointList) {
        return null;
    }

    @Override
    public Response handlePosition(Position position) {
        if (savePosition(position))
            return Response.status(200).build();
        else
            return Response.status(400).build();
    }

    @Override
    public Response insertPosition(Position position) {
        return handlePosition(position);
    }
}
