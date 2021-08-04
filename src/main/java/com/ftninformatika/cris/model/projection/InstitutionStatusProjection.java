package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.InstitutionStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InstitutionStatusProjection", types = {InstitutionStatus.class})
public interface InstitutionStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
