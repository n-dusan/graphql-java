package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.ProductAuthors;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProductAuthorsProjection", types = {ProductAuthors.class})
public interface ProductAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}