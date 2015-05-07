package position.Impl;

import com.google.gson.Gson;
import position.DAO.PositionDAOImpl;
import position.Model.Person;
import position.Model.Position;
import position.PositionService;

import javax.ws.rs.core.Response;

/**
 * Created by ueh093 on 5/5/15.
 */
public class PositionServiceImpl extends PositionDAOImpl implements PositionService {

    public Response getDummy() {

        String ok = "<h1>Dummy says hello</h1>";
        Person p = new Person();
        p.setFirstName("Anders");
        p.setLastName("Selborn");
        p.setAge(42);

        Gson gson = new Gson();
        String json = gson.toJson(p);

        return Response.status(200).entity(json).build();

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
