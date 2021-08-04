package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ThesisStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ThesisStatusProjection", types = {ThesisStatus.class})
public interface ThesisStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
