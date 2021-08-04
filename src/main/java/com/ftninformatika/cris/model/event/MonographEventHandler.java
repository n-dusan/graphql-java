package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Monograph;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Monograph.class)
public class MonographEventHandler {

    @HandleBeforeCreate
    public void handleMonographCreation(Monograph monograph) {
        if (monograph.getCreationDate() == null) {
            monograph.setCreationDate(LocalDateTime.now());
        } else {
            monograph.setLastModificationDate(LocalDateTime.now());
        }
    }
}
