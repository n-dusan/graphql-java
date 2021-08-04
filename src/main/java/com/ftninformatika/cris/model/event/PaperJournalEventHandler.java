package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.PaperJournal;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(PaperJournal.class)
public class PaperJournalEventHandler {

    @HandleBeforeCreate
    public void handlePaperJournalCreation(PaperJournal paperJournal) {
        if (paperJournal.getCreationDate() == null) {
            paperJournal.setCreationDate(LocalDateTime.now());
        } else {
            paperJournal.setLastModificationDate(LocalDateTime.now());
        }
    }
}
