package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PatentType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PatentTypeProjection", types = {PatentType.class})
public interface PatentTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
