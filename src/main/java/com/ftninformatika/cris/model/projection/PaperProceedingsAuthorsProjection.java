package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperProceedingsAuthors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperProceedingsAuthorsProjection", types = {PaperProceedingsAuthors.class})
public interface PaperProceedingsAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}