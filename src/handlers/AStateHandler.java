package handlers;

import exception.ProcessException;
import modale.AModel;
import states.StatesEnum;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public abstract class AStateHandler<T extends AModel> implements IStateHandler {
    protected StatesEnum fromState;
    protected StatesEnum targetState;
    protected T obj;
    private String name;

    public AStateHandler(StatesEnum fromState, StatesEnum targetState, String name) throws ProcessException {
        this(fromState, targetState);
        this.name = name;
    }

    public AStateHandler(StatesEnum fromState, StatesEnum targetState) throws ProcessException {
        if (fromState == null || targetState == null) {
            throw new ProcessException("流程处理器初始化异常！开始和目标状态都不可以为空！");
        }

        this.fromState = fromState;
        this.targetState = targetState;
    }

    @Override
    public void begin() {
        System.out.println("---------------begin-------------------");
        System.out.println("=流程执行前 逻辑处理=");
    }

    @Override
    public abstract void doProcess();

    @Override
    public void end() {
        System.out.println("=流程执行后 逻辑处理=");
        System.out.println("---------------End-------------------");
    }

    public void handle(T obj) throws ProcessException {
        this.obj = obj;
        if (obj.currentState == null || !obj.currentState.equals(fromState)) {
            throw new ProcessException("流程引擎处理不了该数据的状态");
        }

        System.out.println("===============业务逻辑 流程执行开始================");
        begin();
        doProcess();
        end();
        System.out.println("===============业务逻辑 流程执行结束================");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AStateHandler)) return false;

        AStateHandler that = (AStateHandler) o;

        if (fromState != that.fromState) return false;
        return targetState == that.targetState;
    }

    @Override
    public int hashCode() {
        int result = fromState.hashCode();
        result = 31 * result + targetState.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }
}
