package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PatentStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PatentStatusProjection", types = {PatentStatus.class})
public interface PatentStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}