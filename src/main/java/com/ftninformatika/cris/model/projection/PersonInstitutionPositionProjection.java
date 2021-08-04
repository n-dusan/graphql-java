package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PersonInstitutionPosition;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PersonInstitutionPositionProjection", types = {PersonInstitutionPosition.class})
public interface PersonInstitutionPositionProjection {

    Long getId();
    String getName();
    String getDescription();
}
