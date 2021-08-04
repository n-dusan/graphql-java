package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.PaperMonograph;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(PaperMonograph.class)
public class PaperMonographEventHandler {

    @HandleBeforeCreate
    public void handlePaperMonographtCreation(PaperMonograph paperMonograph) {
        if (paperMonograph.getCreationDate() == null) {
            paperMonograph.setCreationDate(LocalDateTime.now());
        } else {
            paperMonograph.setLastModificationDate(LocalDateTime.now());
        }
    }
}
