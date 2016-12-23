package handlers;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public interface IStateHandler {

    public void begin();
    public void doProcess();
    public void end();
}
