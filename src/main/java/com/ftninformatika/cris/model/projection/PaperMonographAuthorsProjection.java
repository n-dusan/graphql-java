package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperMonographAuthors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperMonographAuthorsProjection", types = {PaperMonographAuthors.class})
public interface PaperMonographAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}