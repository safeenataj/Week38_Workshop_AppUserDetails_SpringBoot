package se.lexicon.week38_workshop_appuserdetails.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer authorId;

    @Setter
    @Column( nullable = false, updatable = false)
    private String firstName;

    @Setter
    @Column(nullable = false, updatable = false, length = 100)
    private String lastName;

    @Setter
    @ManyToMany
    @JoinTable(
            name="author_book",
            joinColumns = @JoinColumn(name="author_authorId"),
            inverseJoinColumns = @JoinColumn(name="book_bookId")
    )
    private Set<Book> writtenBooks = new HashSet<>();

    public Author(Integer authorId, String firstName, String lastName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
