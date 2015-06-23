package position.Impl;

import position.DAO.PositionDAOImpl;
import position.Model.Person;
import position.Model.Position;
import position.PositionService;

import javax.ws.rs.core.Response;

/**
 * Created by ueh093 on 5/5/15.
 */
public class PositionServiceImpl extends PositionDAOImpl implements PositionService {

    public String ping() {
        return "PONG!";
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
