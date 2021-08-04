package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.InstitutionType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "InstitutionTypeProjection", types = {InstitutionType.class})
public interface InstitutionTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
