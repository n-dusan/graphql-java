package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperJournalAuthors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperJournalAuthorsProjection", types = {PaperJournalAuthors.class})
public interface PaperJournalAuthorsProjection {

    Long getId();
    Integer getNumOrder();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Person getPerson();
}
