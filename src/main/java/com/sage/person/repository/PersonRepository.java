package com.sage.person.repository;

import com.sage.person.models.Person;

import java.util.Optional;
import java.util.function.Function;

public interface PersonRepository {
  public Optional<Person> getPerson(Function<Person,Boolean> func);
  public Person createPerson(Person p);
  public void deletePerson(Long id);
  public void updatePerson(Person p);
}
