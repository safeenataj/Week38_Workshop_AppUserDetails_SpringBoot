package se.lexicon.week38_workshop_appuserdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.week38_workshop_appuserdetails.entity.AppUser;
import se.lexicon.week38_workshop_appuserdetails.entity.Book;
import se.lexicon.week38_workshop_appuserdetails.entity.BookLoan;
import se.lexicon.week38_workshop_appuserdetails.entity.Details;
import se.lexicon.week38_workshop_appuserdetails.repository.AppUserRepository;
import se.lexicon.week38_workshop_appuserdetails.repository.BookLoanRepository;
import se.lexicon.week38_workshop_appuserdetails.repository.BookRepository;
import se.lexicon.week38_workshop_appuserdetails.repository.DetailsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private AppUserRepository appUserRepository;

    private DetailsRepository detailsRepository;

    private BookRepository bookRepository;

    private BookLoanRepository bookLoanRepository;

    @Autowired
    public MyCommandLineRunner(AppUserRepository appUserRepository, DetailsRepository detailsRepository, BookRepository bookRepository, BookLoanRepository bookLoanRepository) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;
        this.bookRepository = bookRepository;
        this.bookLoanRepository = bookLoanRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

        Details details2 = new Details("markjustin@test.se", "Mark Justin", LocalDate.of(2001, 2, 2));
        AppUser appUser2 = new AppUser(details2.getName(), "mark123", LocalDate.of(2024,2,2), details2);
        detailsRepository.save(details2);
        appUserRepository.save(appUser2);

        Details details3 = new Details("emilyjustin@test.se", "Emily Justin", LocalDate.of(2002, 8, 8));
        AppUser appUser3 = new AppUser(details3.getName(), "emily123", LocalDate.of(2024,8,8), details3);
        detailsRepository.save(details3);
        appUserRepository.save(appUser3);
        System.out.println();

        Book book1 = new Book("bookisbn1", "Book1", 20);
        Book savedBook = bookRepository.save(book1);
        BookLoan bookLoan1 = new BookLoan(savedBook, appUser1);
        BookLoan savedBookLoan = bookLoanRepository.save(bookLoan1);
    }
}
