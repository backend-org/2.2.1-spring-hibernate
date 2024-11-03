package hiber.model;

import javax.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(name = "model")
   private String model;

   @Column(name = "series")
   private String series;

   public Car() {}

   public Car(String model, String series) {
      this.model = model;
      this.series = series;
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getModel() {
      return model;
   }

   public void setModel(String model) {
      this.model = model;
   }

   public String getSeries() {
      return series;
   }

   public void setSeries(String series) {
      this.series = series;
   }
}
