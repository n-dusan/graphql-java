package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Patent;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Patent.class)
public class PatentEventHandler {

    @HandleBeforeCreate
    public void handlePatentCreation(Patent patent) {
        if (patent.getCreationDate() == null) {
            patent.setCreationDate(LocalDateTime.now());
        } else {
            patent.setLastModificationDate(LocalDateTime.now());
        }
    }
}
