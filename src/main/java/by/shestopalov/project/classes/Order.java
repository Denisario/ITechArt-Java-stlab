package by.shestopalov.project.classes;

import by.shestopalov.project.enums.STATE;
import lombok.Getter;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;

@Getter
@Setter
public class Order {
    private static final Logger log = Logger.getLogger(Order.class);
    private int userId;
    private int orderId;
    private ArrayList<Part> parts=new ArrayList<>();
    private int total;
    private Timestamp creationDate;
    private Timestamp complectionDate;
    private Timestamp possibleComplectionDate;
    private STATE state;
    private int partsCount;

    public Order(Timestamp creationDate, Timestamp complectionDate) {
        orderId++;
        this.creationDate=new Timestamp(System.currentTimeMillis());
        this.possibleComplectionDate = creationDate;
        this.complectionDate = complectionDate;
        this.state=STATE.ACCEPTED;
    }

    public Order() {
    }


    public void addPart(Part part){
        log.info("Part added in order");
        this.parts.add(part);
        this.total++;
        this.partsCount+=part.getPrice();
    }

    public void removePart(Part part){
        log.info("Part removed in order");
        this.parts.remove(part);
        this.total--;
        this.partsCount-=part.getPrice();
    }

    public void changeState(STATE state){
        log.info("Order state has been changed");
        this.setState(state);
    }

    @Override
    public String toString() {
        String tmp=new String();
        for (var t:this.parts) {
            tmp+=t;
        }
        return "\n\tOrder{" +
                "orderId=" + orderId +
                ", total=" + total +
                ", creationDate=" + creationDate +
                ", complectionDate=" + complectionDate +
                ", state=" + state +
                ",\n\t parts=" + tmp +
                "}\n";
    }
}
