package se.lexicon.week38_workshop_appuserdetails.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Transactional;
import se.lexicon.week38_workshop_appuserdetails.entity.AppUser;
import se.lexicon.week38_workshop_appuserdetails.entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataJpaTest
public class AppUserRepositoryTest {

    @Autowired
    private AppUserRepository appUserRepository;

    @Autowired
    private DetailsRepository detailsRepository;

    @Test
    @Transactional
    public void testSaveAndFindById() {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        AppUser savedUser = appUserRepository.save(appUser1);
        Assertions.assertNotNull(savedUser);
        Assertions.assertNotNull(savedUser.getId());

        Optional<AppUser> appUserOptional = appUserRepository.findById(savedUser.getId());
        Assertions.assertTrue(appUserOptional.isPresent());
    }

    @Test
    @Transactional
    public void testGetAppUserByUserName() {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        detailsRepository.save(details1);
        AppUser savedUser1 = appUserRepository.save(appUser1);

        Details details2 = new Details("markjustin@test.se", "Mark Justin", LocalDate.of(2001, 2, 2));
        AppUser appUser2 = new AppUser(details2.getName(), "mark123", LocalDate.of(2024,2,2), details2);
        detailsRepository.save(details2);
        appUserRepository.save(appUser2);

        Optional<AppUser> foundUser = appUserRepository.getAppUserByUserName(savedUser1.getUserName());
        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertNotNull(foundUser);
    }

    @Test
    @Transactional
    public void testGetAppUserByDetailsId() {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

        Details details2 = new Details("markjustin@test.se", "Mark Justin", LocalDate.of(2001, 2, 2));
        AppUser appUser2 = new AppUser(details2.getName(), "mark123", LocalDate.of(2024,2,2), details2);
        detailsRepository.save(details2);
        appUserRepository.save(appUser2);

        Optional<AppUser> foundUser = appUserRepository.getAppUserByDetails_Id(details1.getId());
        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertNotNull(foundUser);
    }

    @Test
    @Transactional
    public void testGetAllByRegDateBetween() {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

        List<AppUser> foundUser = appUserRepository.getAllByRegDateBetween(LocalDate.of(2024,1,1),
                LocalDate.of(2024,12,31));
        Assertions.assertNotNull(foundUser);
        Assertions.assertEquals(foundUser.toString(),
                "[AppUser(id=1, userName=Emily Johnson, regDate=2024-09-09, details=Details(id=1, email=emilyjohnson@test.se, name=Emily Johnson, birthDate=2000-09-09))]");
    }

    @Test
    @Transactional
    public void testGetAppUserByUserNameAndPassword() {
        Details details1 = new Details("emilyjohnson@test.se", "Emily Johnson", LocalDate.of(2000, 9, 9));
        AppUser appUser1 = new AppUser(details1.getName(), "emily123", LocalDate.of(2024,9,9), details1);
        detailsRepository.save(details1);
        appUserRepository.save(appUser1);

        Details details2 = new Details("markjustin@test.se", "Mark Justin", LocalDate.of(2001, 2, 2));
        AppUser appUser2 = new AppUser(details2.getName(), "mark123", LocalDate.of(2024,2,2), details2);
        detailsRepository.save(details2);
        appUserRepository.save(appUser2);

        Optional<AppUser> foundUser = appUserRepository.getAppUserByUserNameAndPassword(appUser1.getUserName(), appUser1.getPassword());
        Assertions.assertTrue(foundUser.isPresent());
        Assertions.assertNotNull(foundUser);
    }
}
