package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.PaperProceedings;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(PaperProceedings.class)
public class PaperProceedingsEventHandler {

    @HandleBeforeCreate
    public void handlePaperProceedingsCreation(PaperProceedings paperProceedings) {
        if (paperProceedings.getCreationDate() == null) {
            paperProceedings.setCreationDate(LocalDateTime.now());
        } else {
            paperProceedings.setLastModificationDate(LocalDateTime.now());
        }
    }
}
