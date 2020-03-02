package by.shestopalov.project.classes;
import by.shestopalov.project.Exceptions.PriceException;
import by.shestopalov.project.user.AbstractUser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

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

   public Part() {
   }

   public long getPartId() {
      return partId;
   }

   public void setPartId(long partId) {
      this.partId = partId;
   }

   public String getCategory() {
      return category;
   }

   public void setCategory(String category) {
      this.category = category;
   }

   public int getPrice() {
      return price;
   }

   public void setPrice(int price) throws PriceException {
      if(price<=0) throw new PriceException("Wrong price");
      this.price = price;
   }

   public String getColor() {
      return color;
   }

   public void setColor(String color) {
      this.color = color;
   }

   public ArrayList<String> getPhotos() {
      return photos;
   }

   public void setPhotos(ArrayList<String> photos) {
      this.photos = photos;
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

   public long getCarId() {
      return carId;
   }

   public void setCarId(long carId) {
      this.carId = carId;
   }

   public String getDetail() {
      return detail;
   }

   public void setDetail(String detail) {
      this.detail = detail;
   }

   public long getTotalPart() {
      return totalPart;
   }

   public void setTotalPart(long totalPart) {
      this.totalPart = totalPart;
   }
}
