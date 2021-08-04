package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PersonInstitutionStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PersonInstitutionStatusProjection", types = {PersonInstitutionStatus.class})
public interface PersonInstitutionStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
