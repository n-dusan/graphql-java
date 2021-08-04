package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Thesis;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Thesis.class)
public class ThesisEventHandler {

    @HandleBeforeCreate
    public void handleThesisCreation(Thesis thesis) {
        if (thesis.getCreationDate() == null) {
            thesis.setCreationDate(LocalDateTime.now());
        } else {
            thesis.setLastModificationDate(LocalDateTime.now());
        }
    }

}