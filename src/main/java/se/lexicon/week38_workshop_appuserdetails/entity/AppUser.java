package se.lexicon.week38_workshop_appuserdetails.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "password")
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true, length = 50)
    @Setter private String userName;

    @Column(nullable = false, length = 20)
    private String password;

    @Column(nullable = false)
    @Setter private LocalDate regDate;

    @Setter
    @OneToOne
    @JoinColumn
    private Details details;

    public AppUser(String userName, String password, LocalDate regDate, Details details) {
        this.userName = userName;
        this.password = password;
        this.regDate = regDate;
        this.details = details;
    }
}
