package ua.com.muzland.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private int productPrice;



    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinTable(name = "subCategory_x_product", joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "subCategory_id"))
    private SubCategory subCategory;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL )
    private ProductInformation productInformation;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "brand_x_product", joinColumns = @JoinColumn(name="product_id"),
        inverseJoinColumns = @JoinColumn(name = "brand_id"))
    private Brand brand;

}
