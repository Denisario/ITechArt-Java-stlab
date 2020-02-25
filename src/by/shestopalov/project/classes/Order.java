package by.shestopalov.project.classes;

import by.shestopalov.project.enums.STATE;

import java.util.ArrayList;
import java.util.Date;

public class Order {


    public static int orderId;
    public ArrayList<Part> parts=new ArrayList<>();
    public int partsCount;
    public int total;
    public Date creationDate;
    public Date complectionDate;
    public STATE state;

    public Order(Date creationDate) {
        orderId++;
        this.creationDate = creationDate;
        this.state = STATE.ACCEPTED;

    }

    public Order() {
    }

    public void addPart(Part part){
        this.parts.add(part);
        this.total++;
        this.partsCount+=part.price;
    }

    public void removePart(Part part){
        this.parts.remove(part);
        this.total--;
        this.partsCount-=part.price;
    }

    public void changeState(STATE state){
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

    public int getPartsCount() {
        return partsCount;
    }

    public void setPartsCount(int partsCount) {
        this.partsCount = partsCount;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getComplectionDate() {
        return complectionDate;
    }

    public void setComplectionDate(Date complectionDate) {
        this.complectionDate = complectionDate;
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

                ", partsCount=" + partsCount +
                ", total=" + total +
                ", creationDate=" + creationDate +
                ", complectionDate=" + complectionDate +
                ", state=" + state +
                ",\n\t parts=" + tmp +
                "}\n";
    }
}
