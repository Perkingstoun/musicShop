package ua.com.muzland.Entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductOnPage {
    private int id;
    private String name;
    private int price;
    private String details;
    private String image;
    private String category;
    private String subCategory;
    private String brand;
}
