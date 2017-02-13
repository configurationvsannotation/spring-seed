package com.sage.person.repository;

import com.sage.person.models.Person;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

@Repository
public class FakePersonRepository implements PersonRepository {

  List<Person> personRepo = new ArrayList<>();

  public FakePersonRepository() {
    personRepo.add(new Person(1l, "Biff","Jones"));
    personRepo.add(new Person(2l,"Lyndsey","Fonseca"));
    personRepo.add(new Person(3l,"Angelina","Jolie"));
    personRepo.add(new Person(4l,"Jim","Moso"));
    personRepo.add(new Person(5l,"Oberyn","Martell"));
  }

  @Override
  public Optional<Person> getPerson(Function<Person, Boolean> func) {
    return personRepo.stream().filter(p -> func.apply(p)).findFirst();
  }

  @Override
  public Person createPerson(Person person) {
    Optional<Person> max = personRepo.stream().max(Comparator.comparingLong(Person::getId));
    Person newPerson = new Person(max.get().getId() + 1, person.getFirstName(), person.getLastName());
    personRepo.add(newPerson);
    return newPerson;
  }

  @Override
  public void deletePerson(Long id) {
    personRepo.removeAll(personRepo.stream().filter(p -> p.getId() == id).collect(Collectors.toList()));
  }

  @Override
  public void updatePerson(Person person) {
    int index = personRepo.indexOf(person);
    if(index > -1)personRepo.add(index,person);
  }


}
