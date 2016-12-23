import exception.ProcessException;
import handlers.AStateHandler;
import model.AModel;
import states.StatesEnum;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class Process {
    private StatesEnum startState;
    private StatesEnum targetState;

    private AStateHandler handler;
    Process(StatesEnum startState,StatesEnum targetStage,AStateHandler handler){
        this.startState = startState;
        this.targetState = targetStage;
        this.handler = handler;
        System.out.println(toString());
    }

    public <T extends AModel> void  handle(T model) throws ProcessException {
        handler.handle(model);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Process)) return false;

        Process process = (Process) o;

        if (startState != process.startState) return false;
        if (targetState != process.targetState) return false;
        return handler.equals(process.handler);
    }

    @Override
    public int hashCode() {
        int result = startState.hashCode();
        result = 31 * result + targetState.hashCode();
        result = 31 * result + handler.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String name = handler.getName();
        if(name==null){
            name = this.getClass().getName();
        }
        return this.startState.name()+"->"+this.targetState.name()+":"+name;
    }
}
