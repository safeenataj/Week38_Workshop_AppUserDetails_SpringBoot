package se.lexicon.week38_workshop_appuserdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.week38_workshop_appuserdetails.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {
// Find authors by their first name.
   List<Author> findByFirstName(String firstName);
  //  Find authors by their last name

    List<Author> findByLastName(String lastName);
//Find authors by their first name or last name containing a keyword
    List<Author> findByFirstNameContainingOrLastNameContaining(String firstNameKeyword, String lastNameKeyword);
   // Find authors by a book's ID.
    List<Author> findByBooksBookId(Long bookId);

    // Update an author's name by their ID.
   public Author updateAuthorName(Integer authorId, String newFirstName, String newLastName) {
        Optional<Author> authorOptional = authorRepository.findById(authorId);
        if (authorOptional.isPresent()) {
            Author author = authorOptional.get();
            author.setFirstName(newFirstName);
            author.setLastName(newLastName);
            return authorRepository.save(author);
        }
        return null; // Handle error cases appropriately
   }
    //Delete an author by their ID.

       void deleteById(authorId);
}
