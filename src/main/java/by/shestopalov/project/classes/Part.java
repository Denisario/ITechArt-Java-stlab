package by.shestopalov.project.classes;
import by.shestopalov.project.Exceptions.PriceException;
import by.shestopalov.project.user.AbstractUser;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.log4j.Logger;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public class Part {
   public static long total=0;
   private static final Logger log = Logger.getLogger(AbstractUser.class);
   private long partId;
   private long carId;
   private String category;
   private int price;
   private String color;
   private String detail;
   private ArrayList<String> photos;
   private long totalPart;

   public void setPrice(int price) throws PriceException {
      if(price<=0) throw new PriceException("Wrong price");
      this.price = price;
   }

   @Override
   public String toString() {
      return "\n\t\tPart{" +
              "partId=" + partId +
              ", carId=" + carId +
              ", category='" + category + '\'' +
              ", price=" + price +
              ", color='" + color + '\'' +
              ", photos=" + photos +
              "}\n";
   }

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      Part part = (Part) o;
      return getPartId() == part.getPartId() &&
              getPrice() == part.getPrice() &&
              getCarId() == (part.getCarId()) &&
              getCategory().equals(part.getCategory()) &&
              getColor().equals(part.getColor()) &&
              getPhotos().equals(part.getPhotos());
   }
}
