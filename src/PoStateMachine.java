import exception.NoProcessException;
import exception.ProcessException;
import handlers.pohandlers.*;
import states.StatesEnum;

import java.util.*;


/**
 * Created by winn2048@gmail.com on 12/23/2016.
 *
 * This is PO order state machine.<br/>
 * In po order processes have this state:
 * new->publish
 * new->cancel
 * publish-> printed
 * printed-> received
 * received->checked
 * checked->done
 *
 * you can implement every state process(handler)
 */
public class PoStateMachine {
    private Map<String,Process> map = new HashMap<String,Process>();
    private static PoStateMachine stateMachine;


    private PoStateMachine() {
        System.out.println("===============PO Define the process===================");
        try {
            map.put(StatesEnum.NEW.name() + StatesEnum.PUBLISH.name(), new Process(StatesEnum.NEW, StatesEnum.PUBLISH, new NewToPublishHandler(StatesEnum.NEW, StatesEnum.PUBLISH)));
            map.put(StatesEnum.NEW.name() + StatesEnum.CANCEL.name(), new Process(StatesEnum.NEW, StatesEnum.CANCEL, new NewToCancelHandler(StatesEnum.NEW, StatesEnum.CANCEL)));
            map.put(StatesEnum.PUBLISH.name() + StatesEnum.PRINTED.name(), new Process(StatesEnum.PUBLISH, StatesEnum.PRINTED, new PublishToPrintedHandler(StatesEnum.PUBLISH, StatesEnum.PRINTED)));
            map.put(StatesEnum.PRINTED.name() + StatesEnum.RECEIVED.name(), new Process(StatesEnum.PRINTED, StatesEnum.RECEIVED, new PrintedToReceivedHandler(StatesEnum.PRINTED, StatesEnum.RECEIVED)));
            map.put(StatesEnum.RECEIVED.name() + StatesEnum.CHECKED.name(), new Process(StatesEnum.RECEIVED, StatesEnum.CHECKED, new ReceivedToCheckedHandler(StatesEnum.RECEIVED, StatesEnum.CHECKED)));
            map.put(StatesEnum.CHECKED.name() + StatesEnum.DONE.name(), new Process(StatesEnum.CHECKED, StatesEnum.DONE, new CheckedToDoneHandler(StatesEnum.CHECKED, StatesEnum.DONE)));
        }catch (ProcessException pe){
            System.out.println("PO State Machine init failed："+pe.getMsg());
        }
        System.out.println("===============PO Define the process Done.===================");
    }

    private static class SingletonHolder {
        private static final PoStateMachine INSTANCE = new PoStateMachine();
    }

    public static PoStateMachine getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public Process getProcess(StatesEnum startState, StatesEnum targetState) throws NoProcessException {
        if(startState==null || targetState==null){
            throw new NoProcessException("Must have start state and target state!");
        }
        Process process = map.get(startState.name()+targetState.name());

        if(process==null){
            throw  new NoProcessException(startState.name()+"->"+targetState.name()+",  Engine Cant process！");
        }
        return process;
    }



}
