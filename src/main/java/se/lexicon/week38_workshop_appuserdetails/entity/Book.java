package se.lexicon.week38_workshop_appuserdetails.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    @Setter
    @Column(unique = true, nullable = false, updatable = false)
    private String isbn;


    @Setter
    @Column(nullable = false, updatable = false, length = 100)
    private String title;

    @Setter
    @Column(updatable = false, nullable = false)
    private int maxLoanDays;
    @Setter
    @ManyToMany
            (mappedBy = "writtenBooks")

    private Set<Author> authorset = new HashSet<>();


    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }
}
