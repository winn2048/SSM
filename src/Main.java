import exception.NoProcessException;
import exception.ProcessException;
import modale.PoOrder;
import states.StatesEnum;

public class Main {

    public static void main(String[] args) {
        PoStateMachine stateMachine = PoStateMachine.getInstance();
        System.out.println("*************************************Simple state machine*************************************************************");
        PoOrder po = new PoOrder();

        try {
            //new to cancel
            System.out.println("无状态对象处理：");
            Process p = stateMachine.getProcess(StatesEnum.NEW, StatesEnum.CANCEL);
            p.handle(po);
        } catch (NoProcessException e) {
            System.out.println(e.getMsg());
        } catch (ProcessException e) {
            System.out.println(e.getMsg());
        }

        System.out.println("**************************************************************************************************");
        try {
            //new to publish
            System.out.println("正常流程处理：");
            Process p = stateMachine.getProcess(StatesEnum.NEW, StatesEnum.PUBLISH);
            po.setCurrentState(StatesEnum.NEW);
            p.handle(po);
        } catch (NoProcessException e) {
            System.out.println(e.getMsg());
        } catch (ProcessException e) {
            System.out.println(e.getMsg());
        }

        System.out.println("**************************************************************************************************");

        try {
            //publish to new
            System.out.println("非正常流程处理：");
            Process p = stateMachine.getProcess(StatesEnum.PUBLISH, StatesEnum.NEW);
            po.setCurrentState(StatesEnum.NEW);
            p.handle(po);
        } catch (NoProcessException e) {
            System.out.println(e.getMsg());
        } catch (ProcessException e) {
            System.out.println(e.getMsg());
        }



    }
}
