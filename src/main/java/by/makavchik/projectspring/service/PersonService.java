package by.makavchik.projectspring.service;

import by.makavchik.projectspring.entity.Person;

import java.util.List;
import java.util.Optional;
import java.lang.Long;


public interface PersonService {
    List<Person> getAllPerson();
    void addNewPerson(Person person);
    void deletePerson(Person person );
    void editPerson(Person person);
    Optional<Person> getById(Long id);

}
