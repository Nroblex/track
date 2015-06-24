package position.Model;

import org.codehaus.enunciate.json.JsonRootType;

/**
 * Created by ueh093 on 6/23/15.
 */
@JsonRootType
public abstract class ResponseMessage {
    private String answer;

    public ResponseMessage(ResponseType resp, final String answer) {this.answer=answer;}
    public String getAnswer() { return this.answer;}
    public void setAnswer(final String answer) { this.answer=answer;}

}
