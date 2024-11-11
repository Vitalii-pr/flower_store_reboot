package org.example.flowerstore_continue.flowerStore;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;


@NoArgsConstructor
@Setter
@ToString
@Entity
@Data
public class Flower extends Item {
    @Id @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @Getter
    private double sepalLength;
    private FlowerColor color;
    @Getter @Setter
    private double price;
    @Getter
    private FlowerType flowerType;

    public Flower(double sepal, FlowerColor fl, double price, FlowerType flt){
        this.sepalLength = sepal;
        this.price = price;
        this.color = fl;
        this.flowerType = flt;
    }

    @Override
    public double getPrice(){
        return this.price;
    }


    public String getColor() {
        return color.toString();
    }



}
