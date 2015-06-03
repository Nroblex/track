package gpx;

import org.jboss.resteasy.plugins.providers.multipart.MultipartFormDataInput;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * Created by ueh093 on 5/7/15.
 */
@Path("/gpx")
public interface GpxService {

    @POST
    @Path("/import")
    @Consumes("multipart/form-data")
    public Response importGpx(MultipartFormDataInput input);

}
