package com.sage.person.models;

public class Person {
  private Long id;
  private String firstName;
  private String lastName;

  public Person() {
  }

  public Person(Long id, String firstName, String lastName) {
    this.id = id;
    this.firstName = firstName;
    this.lastName = lastName;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    Person person = (Person) o;

    return id.equals(person.id);
  }

  @Override
  public int hashCode() {
    return id.hashCode();
  }
}
