package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.MonographOfPapers;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(MonographOfPapers.class)
public class MonographOfPapersEventHandler {

    @HandleBeforeCreate
    public void handleMonographOfPapersCreation(MonographOfPapers monographOfPapers) {
        if (monographOfPapers.getCreationDate() == null) {
            monographOfPapers.setCreationDate(LocalDateTime.now());
        } else {
            monographOfPapers.setLastModificationDate(LocalDateTime.now());
        }
    }
}
