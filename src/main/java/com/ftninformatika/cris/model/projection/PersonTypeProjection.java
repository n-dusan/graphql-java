package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PersonType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PersonTypeProjection", types = {PersonType.class})
public interface PersonTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
