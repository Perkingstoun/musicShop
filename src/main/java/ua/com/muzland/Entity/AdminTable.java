package ua.com.muzland.Entity;
import lombok.*;

import javax.persistence.Entity;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class AdminTable {
    private  int id;
    private String pName;
    private String pBrand;
    private int pPrice;
    private String pPhoto;
    private String cName;
    private String scName;
    private String descriprion;


}
