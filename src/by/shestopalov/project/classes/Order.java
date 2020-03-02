package by.shestopalov.project.classes;

import by.shestopalov.project.enums.STATE;
import org.apache.log4j.Logger;

import java.sql.Timestamp;
import java.util.ArrayList;

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

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public ArrayList<Part> getParts() {
        return parts;
    }

    public void setParts(ArrayList<Part> parts) {
        this.parts = parts;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public STATE getState() {
        return state;
    }

    public void setState(STATE state) {
        this.state = state;
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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public Timestamp getComplectionDate() {
        return complectionDate;
    }

    public void setComplectionDate(Timestamp complectionDate) {
        this.complectionDate = complectionDate;
    }

    public Timestamp getPossibleComplectionDate() {
        return possibleComplectionDate;
    }

    public void setPossibleComplectionDate(Timestamp possibleComplectionDate) {
        this.possibleComplectionDate = possibleComplectionDate;
    }

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }
}
