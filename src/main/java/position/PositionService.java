package position;

import position.Model.Person;
import position.Model.Position;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by ueh093 on 5/5/15.
 */

@Path("/position")
public interface PositionService {

    @GET
    @Path("/ping")
    @Consumes(MediaType.APPLICATION_JSON)
    public String ping();

    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson(final Person person);

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handlePosition(final Position position) throws SQLException, ClassNotFoundException;


    @PUT
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPosition(final Position position);

}
