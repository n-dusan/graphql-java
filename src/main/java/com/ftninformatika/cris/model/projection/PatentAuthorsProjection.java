package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PatentAuthors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PatentAuthorsProjection", types = {PatentAuthors.class})
public interface PatentAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}