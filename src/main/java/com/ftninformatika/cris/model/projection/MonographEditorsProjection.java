package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.MonographEditors;
import com.ftninformatika.cris.model.MonographOfPapers;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MonographEditorsProjection", types = {MonographEditors.class})
public interface MonographEditorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
    MonographOfPapers getMonographOfPapers();
}
