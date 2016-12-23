package modale;

import states.StatesEnum;

import java.io.Serializable;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public abstract class AModel implements Serializable {
      public  StatesEnum currentState;

    public StatesEnum getCurrentState() {
        return currentState;
    }

    public void setCurrentState(StatesEnum currentState) {
        this.currentState = currentState;
    }
}
