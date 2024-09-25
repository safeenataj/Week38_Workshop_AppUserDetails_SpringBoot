package se.lexicon.week38_workshop_appuserdetails.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.week38_workshop_appuserdetails.entity.BookLoan;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {
//    Find book loans by borrower's ID.
    List<BookLoan> findByBorrower_Id(int borrowerId);

//    Find book loans by book ID.
    List<BookLoan> findByBook_BookId(int bookId);

//    Find book loans that are not yet returned.
    List<BookLoan> findByReturnedFalse();

//    Find overdue book loans (due date is past and not returned).
    List<BookLoan> findByDueDateBeforeAndReturnedFalse(LocalDate date);

//    Find book loans between specified dates.
    List<BookLoan> findByLoanDateBetween(LocalDate startDate, LocalDate endDate);

//    Mark a book loan as returned by its loan ID.
    @Modifying
    @Query("update BookLoan b set b.returned = true where b.bookLoanId = :loanId")
    void updateByBookLoanId(int loanId);
}
