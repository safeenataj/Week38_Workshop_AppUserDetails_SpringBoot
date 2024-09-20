package se.lexicon.week38_workshop_appuserdetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.week38_workshop_appuserdetails.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {
    Optional<AppUser> getAppUserByUserName(String userName);

    List<AppUser> getAllByRegDateBetween(LocalDate regDate, LocalDate regDate2);

    Optional<AppUser> getAppUserByDetails_Id(Integer details_id);

    Optional<AppUser> findByDetailsEmailIgnoreCase(String email);

    Optional<AppUser> getAppUserByUserNameAndPassword(String userName, String password);

//    Find user by email ignore case.
//    @Query("select * from app_user where details_id in (select id from details where email = :mailid)")
//    AppUser queryAppUserBy(@Param("email") String mailid);
}