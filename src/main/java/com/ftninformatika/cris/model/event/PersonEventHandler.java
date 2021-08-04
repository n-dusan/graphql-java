package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Person.class)
public class PersonEventHandler {

    @HandleBeforeCreate
    public void handlePersonCreation(Person person) {
        if (person.getCreationDate() == null) {
            person.setCreationDate(LocalDateTime.now());
        } else {
            person.setLastModificationDate(LocalDateTime.now());
        }
    }
}
