package position;

import position.Model.Person;
import position.Model.Position;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

/**
 * Created by ueh093 on 5/5/15.
 */

@Path("/position")
public interface PositionService {


    @POST
    @Path("/person")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response savePerson(final Person person);

    @POST
    @Path("/position")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response handlePosition(final Position position) throws SQLException, ClassNotFoundException;


    @PUT
    @Path("position")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response insertPosition(final Position position);

}
