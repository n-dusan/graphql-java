package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PersonInstitutionFunction;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PersonInstitutionFunctionProjection", types = {PersonInstitutionFunction.class})
public interface PersonInstitutionFunctionProjection {

    Long getId();
    String getName();
    String getDescription();
}
