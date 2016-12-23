package modale;

/**
 * Created by winn2048@gmail.com on 12/23/2016.
 */
public class PoOrder extends AModel {

    private String id;
    private String orderId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public String toString() {
        return "modale.PoOrder{" +
                "id='" + id + '\'' +
                ", currentState=" + currentState +
                ", orderId='" + orderId + '\'' +
                '}';
    }
}
