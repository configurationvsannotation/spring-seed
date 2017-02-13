package com.sage.person.repository;

import com.sage.person.models.Person;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class FakePersonRepositoryTest {
  @Test
  public void getPerson() throws Exception {
    FakePersonRepository f = new FakePersonRepository();
    Optional<Person> jolie = f.getPerson(p -> p.getLastName().equalsIgnoreCase("Jolie"));

    assertTrue(jolie.isPresent());
    assertEquals("Angelina",jolie.get().getFirstName());
  }

}