package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Journal;
import com.ftninformatika.cris.model.JournalGuestEditors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "JournalGuestEditorsProjection", types = {JournalGuestEditors.class})
public interface JournalGuestEditorsProjection {

    Long getId();
    String getYear();
    String getVolume();
    String getNumber();
    Integer getNumberOfGuestEditors();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Journal getJournal();
    Person getPerson();
}