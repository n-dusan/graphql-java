package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Journal;
import com.ftninformatika.cris.model.JournalEditors;
import com.ftninformatika.cris.model.Person;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Projection(name = "JournalEditorsProjection", types = {JournalEditors.class})
public interface JournalEditorsProjection {

    Long getId();
    String getStartYear();
    String getStartVolume();
    String getStartNumber();
    String getEndYear();
    String getEndVolume();
    String getEndNumber();
    Integer getNumberOfEditors();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    String getEmail();
    String getAffiliations();
    Journal getJournal();
    Person getPerson();
}