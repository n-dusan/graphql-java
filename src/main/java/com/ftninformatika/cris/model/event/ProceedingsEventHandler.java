package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Proceedings;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Proceedings.class)
public class ProceedingsEventHandler {

    @HandleBeforeCreate
    public void handleProceedingsCreation(Proceedings proceedings) {
        if (proceedings.getCreationDate() == null) {
            proceedings.setCreationDate(LocalDateTime.now());
        } else {
            proceedings.setLastModificationDate(LocalDateTime.now());
        }
    }
}