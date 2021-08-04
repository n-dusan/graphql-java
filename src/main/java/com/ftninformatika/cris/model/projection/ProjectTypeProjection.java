package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ProjectType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProjectTypeProjection", types = ProjectType.class)
public interface ProjectTypeProjection {

    Long getId();
    String getName();
    String getDescription();

}
