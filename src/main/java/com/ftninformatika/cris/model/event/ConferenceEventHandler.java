package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Conference;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Conference.class)
public class ConferenceEventHandler {

    @HandleBeforeCreate
    public void handleConferenceCreation(Conference conference) {
        if (conference.getCreationDate() == null) {
            conference.setCreationDate(LocalDateTime.now());
        } else {
            conference.setLastModificationDate(LocalDateTime.now());
        }
    }
}