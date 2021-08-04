package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ProjectStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProjectStatusProjection", types = {ProjectStatus.class})
public interface ProjectStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
