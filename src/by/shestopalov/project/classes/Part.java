package by.shestopalov.project.classes;
import by.shestopalov.project.Exceptions.PriceException;
import by.shestopalov.project.user.AbstractUser;
import org.apache.log4j.Logger;

import java.util.ArrayList;

public class Part {
   private static final Logger log = Logger.getLogger(AbstractUser.class);
   public int partId;
   public Car car;
   public String category;
   public int price;
   public String color;
   public ArrayList<String> photos;

   public Part(int partId, Car car, String category, int price, String color) {
      log.info("Part has been created");
      this.partId = partId;
      this.car = car;
      this.category = category;
      this.price = price;
      this.color = color;
   }

   public Part() {
   }

   public int getPartId() {
      return partId;
   }

   public void setPartId(int partId) {
      this.partId = partId;
   }

   public Car getCar() {
      return car;
   }

   public void setCar(Car car) {
      this.car = car;
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
              ", car=" + car +
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
              getCar().equals(part.getCar()) &&
              getCategory().equals(part.getCategory()) &&
              getColor().equals(part.getColor()) &&
              getPhotos().equals(part.getPhotos());
   }
}
