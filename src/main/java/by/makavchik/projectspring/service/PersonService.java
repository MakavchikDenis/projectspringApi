package by.makavchik.projectspring.service;

import by.makavchik.projectspring.entity.Person;
import by.makavchik.projectspring.exception.ResourceNotFoundException;

import java.util.List;
import java.util.Optional;
import java.lang.Long;


public interface PersonService {
    List<Person> getAllPerson();
    void addNewPerson(Person person);
    void deletePerson(Person person );
    void editPerson(Person person,Long id);
    Person getById(Long id) throws ResourceNotFoundException;

}
