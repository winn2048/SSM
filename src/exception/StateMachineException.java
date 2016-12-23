package exception;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class StateMachineException extends Exception {
    private String msg;

    public StateMachineException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public StateMachineException(String msg, Exception e) {
        super(msg, e);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
