package ua.com.muzland.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;


@Getter
@Setter
@ToString
@NoArgsConstructor
public class CartTable {
    private String img;
    private String name;
    private String brand;
    private int price;
    private int amount;
    private int sumPrice;

}
