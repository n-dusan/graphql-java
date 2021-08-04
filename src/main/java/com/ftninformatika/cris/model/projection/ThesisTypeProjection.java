package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ThesisType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ThesisTypeProjection", types = {ThesisType.class})
public interface ThesisTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
