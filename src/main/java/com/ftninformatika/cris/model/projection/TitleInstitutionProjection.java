package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.TitleInstitution;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "TitleInstitutionProjection", types = {TitleInstitution.class})
public interface TitleInstitutionProjection {

    Long getId();
    String getTitle();
    String getYear();
    Institution getInstitution();
    Person getPerson();

}
