package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.MonographAuthors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MonographAuthorsProjection", types = {MonographAuthors.class})
public interface MonographAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}