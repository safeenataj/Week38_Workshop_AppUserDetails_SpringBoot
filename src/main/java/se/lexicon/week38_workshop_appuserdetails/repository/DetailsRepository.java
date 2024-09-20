package se.lexicon.week38_workshop_appuserdetails.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.week38_workshop_appuserdetails.entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {
    Optional<Details> getDetailsByEmail(String email);

    List<Details> getDetailsByNameContains(String name);

    Optional<Details> getDetailsByNameEqualsIgnoreCase(String name);

    List<Details> getAllByBirthDateBetween(LocalDate birthDate, LocalDate birthDate2);
}
