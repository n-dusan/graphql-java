package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.PersonName;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PersonNameProjection", types = {PersonName.class})
public interface PersonNameProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    Person getPerson();
}