package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Project;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Project.class)
public class ProjectEventHandler {

    @HandleBeforeCreate
    public void handleProjectCreation(Project project) {
        if (project.getCreationDate() == null) {
            project.setCreationDate(LocalDateTime.now());
        } else {
            project.setLastModificationDate(LocalDateTime.now());
        }
    }

}