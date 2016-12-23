package handlers.pohandlers;

import exception.ProcessException;
import handlers.AStateHandler;
import states.StatesEnum;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class PrintedToReceivedHandler extends AStateHandler {

    public PrintedToReceivedHandler(StatesEnum fromState, StatesEnum targetState) throws ProcessException {
        super(fromState, targetState);
        System.out.println("===========handlers.pohandlers.PrintedToReceivedHandler  init===============");
    }


    @Override
    public void begin() {
        super.begin();
        System.out.println("===========handlers.pohandlers.PrintedToReceivedHandler  begin===============");
    }

    @Override
    public void doProcess() {
        System.out.println("===========handlers.pohandlers.PrintedToReceivedHandler  doProcess===============");
    }

    @Override
    public void end() {
        super.end();
        System.out.println("===========handlers.pohandlers.PrintedToReceivedHandler  end===============");
    }
}
