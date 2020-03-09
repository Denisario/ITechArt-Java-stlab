package by.shestopalov.project.classes;

import by.shestopalov.project.enums.STATE;
import by.shestopalov.project.json.DateDeserializer;
import by.shestopalov.project.json.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.sql.Date;
import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Order {
    private static final Logger log = Logger.getLogger(Order.class);
    private int userId;
    private int orderId;
    private ArrayList<Part> parts=new ArrayList<>();
    private int total;
    @JsonSerialize(using= DateSerializer.class)
    @JsonDeserialize(using= DateDeserializer.class)
    private Date creationDate;
    @JsonSerialize(using= DateSerializer.class)
    @JsonDeserialize(using= DateDeserializer.class)
    private Date complectionDate;
    @JsonSerialize(using= DateSerializer.class)
    @JsonDeserialize(using= DateDeserializer.class)
    private Date possibleComplectionDate;
    private STATE state;
    private int partsCount;

    public Order(Date creationDate, Date complectionDate) {
        orderId++;
        this.creationDate=new Date(System.currentTimeMillis());
        this.possibleComplectionDate = creationDate;
        this.complectionDate = complectionDate;
        this.state=STATE.ACCEPTED;
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
