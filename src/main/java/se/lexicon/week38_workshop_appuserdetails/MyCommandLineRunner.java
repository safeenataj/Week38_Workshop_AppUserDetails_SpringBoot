package se.lexicon.week38_workshop_appuserdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import se.lexicon.week38_workshop_appuserdetails.entity.AppUser;
import se.lexicon.week38_workshop_appuserdetails.entity.Details;
import se.lexicon.week38_workshop_appuserdetails.repository.AppUserRepository;
import se.lexicon.week38_workshop_appuserdetails.repository.DetailsRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
public class MyCommandLineRunner implements CommandLineRunner {
    private AppUserRepository appUserRepository;

    private DetailsRepository detailsRepository;

    @Autowired
    public MyCommandLineRunner(AppUserRepository appUserRepository, DetailsRepository detailsRepository) {
        this.appUserRepository = appUserRepository;
        this.detailsRepository = detailsRepository;
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

        System.out.println("-----------------------------------APP USER REPOSITORY----------------------------------");
        System.out.println("------------------------------------FIND BY USERNAME------------------------------------");
        Optional<AppUser> findByUserName = appUserRepository.getAppUserByUserName(appUser2.getUserName());
        findByUserName.ifPresent(System.out::println);
        System.out.println();

        System.out.println("--------------------------------FIND BETWEEN 2 REG DATES--------------------------------");
        LocalDate startRegDate = LocalDate.of(2024,1,1);
        LocalDate endRegDate = LocalDate.of(2024,12,31);
        List<AppUser> findBetweenTwoRegDatesList = appUserRepository.getAllByRegDateBetween(startRegDate, endRegDate);
        findBetweenTwoRegDatesList.forEach(System.out::println);
        System.out.println();

        System.out.println("-----------------------------------FIND BY DETAILS ID-----------------------------------");
        Optional<AppUser> findByDetailsId = appUserRepository.getAppUserByDetails_Id(appUser2.getDetails().getId());
        findByDetailsId.ifPresent(System.out::println);
        System.out.println();

        System.out.println("-------------------------------FIND BY DETAILS EMAIL ID---------------------------------");
        Optional<AppUser> findByDetailsEmail = appUserRepository.findByDetailsEmailIgnoreCase(details1.getEmail());
        findByDetailsEmail.ifPresent(System.out::println);
        System.out.println();

        System.out.println("------------------------------FIND BY USERNAME AND PASSWORD-----------------------------");
        Optional<AppUser> findByUserPass = appUserRepository.getAppUserByUserNameAndPassword(appUser2.getUserName(), appUser2.getPassword());
        findByUserPass.ifPresent(System.out::println);
        System.out.println();

        System.out.println("-----------------------------------DETAILS REPOSITORY-----------------------------------");
        System.out.println("-------------------------------------FIND BY EMAIL--------------------------------------");
        Optional<Details> findByEmail = detailsRepository.getDetailsByEmail(details2.getEmail());
        findByEmail.ifPresent(System.out::println);
        System.out.println();

        System.out.println("---------------------------------FIND BY NAME CONTAINS----------------------------------");
        String findByNameContains = "mil";
        List<Details> findByNameContainsList = detailsRepository.getDetailsByNameContains(findByNameContains);
        System.out.println(findByNameContainsList);
        System.out.println();

        System.out.println("----------------------------FIND BY NAME EQUALS IGNORE CASE-----------------------------");
        String findByNameString = "emily justin";
        Optional<Details> findByNameEqualsIgnoreCase = detailsRepository.getDetailsByNameEqualsIgnoreCase(findByNameString);
        findByNameEqualsIgnoreCase.ifPresent(System.out::println);
        System.out.println();

        System.out.println("-------------------------------FIND BETWEEN 2 BIRTH DATES-------------------------------");
        LocalDate startBirthDate = LocalDate.of(2000,1,1);
        LocalDate endBirthDate = LocalDate.of(2001,12,31);
        List<Details> findBetweenTwoBirthDatesList = detailsRepository.getAllByBirthDateBetween(startBirthDate, endBirthDate);
        findBetweenTwoBirthDatesList.forEach(System.out::println);
        System.out.println();
    }
}
