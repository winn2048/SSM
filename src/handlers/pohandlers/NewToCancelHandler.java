package handlers.pohandlers;

import exception.ProcessException;
import handlers.AStateHandler;
import states.StatesEnum;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class NewToCancelHandler extends AStateHandler {

    public NewToCancelHandler(StatesEnum fromState, StatesEnum targetState) throws ProcessException {
        super(fromState, targetState);
        System.out.println("===========handlers.pohandlers.NewToCancelHandler  init===============");
    }

    @Override
    public void begin() {
        super.begin();
        System.out.println("===========handlers.pohandlers.NewToCancelHandler  begin===============");
    }

    @Override
    public void doProcess() {
        System.out.println("===========handlers.pohandlers.NewToCancelHandler  doProcess===============");
    }

    @Override
    public void end() {
        super.end();
        System.out.println("===========handlers.pohandlers.NewToCancelHandler  end===============");
    }


}
