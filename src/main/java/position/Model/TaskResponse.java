package position.Model;

/**
 * Created by ueh093 on 6/23/15.
 */
public class TaskResponse extends ResponseMessage {

    public TaskResponse(String answer) {
        super(ResponseType.response_sucess, answer);
    }
}
