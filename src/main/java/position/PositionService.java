package position;

import position.Model.Person;
import position.Model.PingResponse;
import position.Model.Position;
import position.Model.TaskResponse;
import position.Model.TrackPoint;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by ueh093 on 5/5/15.
 */

@Path("/position")
@Produces(MediaType.APPLICATION_JSON)
public interface PositionService {

    @GET
    @Path("/ping")
    public PingResponse ping();

    @POST
    @Path("/post")
    @Consumes(MediaType.APPLICATION_JSON)
    public TaskResponse post(Person person);

    @POST
    @Path("/trackpoint")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTrackPoint(TrackPoint trackPoint);

    @POST
    @Path("/trackpoints")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveTrackPoints(List<TrackPoint> trackPointList);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handlePosition(final Position position) throws SQLException, ClassNotFoundException;


    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPosition(final Position position);

}
