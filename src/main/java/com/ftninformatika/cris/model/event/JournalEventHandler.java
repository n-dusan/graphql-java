package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Journal;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Journal.class)
public class JournalEventHandler {

    @HandleBeforeCreate
    public void handleJournalCreation(Journal journal) {
        if (journal.getCreationDate() == null) {
            journal.setCreationDate(LocalDateTime.now());
        } else {
            journal.setLastModificationDate(LocalDateTime.now());
        }
    }
}
