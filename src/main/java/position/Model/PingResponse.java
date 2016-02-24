package position.Model;

import org.codehaus.enunciate.json.JsonRootType;

/**
 * Created by ueh093 on 6/23/15.
 */
@JsonRootType
public class PingResponse extends ResponseMessage{

    public PingResponse(final String answer) {
        super(ResponseType.RESPONSE_PING, answer);
    }
}
