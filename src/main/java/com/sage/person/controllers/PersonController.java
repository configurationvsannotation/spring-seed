package com.sage.person.controllers;

import com.sage.person.models.Person;
import com.sage.person.repository.PersonRepository;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;


@RestController
public class PersonController {

  protected final Log logger = LogFactory.getLog(this.getClass());

  @Autowired
  private PersonRepository personRepository;
  private Person notFound = new Person(-1l, "Not", "Found");;

  @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Person get(@PathVariable Long  id){
    logger.debug(String.format("GET request for Person %d",id));
    return personRepository.getPerson(p -> p.getId() == id).orElse(notFound);
  }

  @RequestMapping(value = "",method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Person create(@RequestBody  Person p){
    logger.debug(String.format("POST request for person: %s, %s", p.getLastName(), p.getFirstName()));
    return personRepository.createPerson(p);
  }

  @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
  public void delete(@PathVariable Long  id){
    logger.debug(String.format("DELETE request for person: %d", id));
    personRepository.deletePerson(id);
  }
  @RequestMapping(value = "/{id}",method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void update(@PathVariable Long  id,@RequestBody  Person p){
    logger.debug(String.format("PUT request for person: %d", id));
    p.setId(id);
    personRepository.updatePerson(p);
  }


}
