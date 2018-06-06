package ua.com.muzland.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor

public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String subCategoryName;

    public SubCategory(String subCategoryName) {
        this.subCategoryName = subCategoryName;
    }

    public SubCategory(String subCategoryName, Category category) {
        this.subCategoryName = subCategoryName;
        this.category = category;
    }

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "category_x_subCategory", joinColumns = @JoinColumn(name = "subCategory_id"),
        inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Category category;


    @OneToMany(fetch = FetchType.LAZY, cascade =  CascadeType.REFRESH)
    @JoinTable(name = "subCategory_x_product", joinColumns = @JoinColumn(name = "subCategory_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> product;
}
