package ua.com.muzland.Entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString

@NoArgsConstructor
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int age;
    private String userAvatar;



    @OneToOne(mappedBy = "userProfile", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User  user;

}
