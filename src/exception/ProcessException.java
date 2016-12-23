package exception;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class ProcessException extends Exception {
    String msg;
    public ProcessException(String msg){
        super(msg);
        this.msg = msg;
    }
    public ProcessException(String msg, Exception e){
        super(msg,e);
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
