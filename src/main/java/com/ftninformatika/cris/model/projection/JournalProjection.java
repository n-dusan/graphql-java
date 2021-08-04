package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Journal;
import com.ftninformatika.cris.model.JournalStatus;
import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.Publisher;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "JournalProjection", types = {Journal.class})
public interface JournalProjection {

    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getPissn();
    String getEissn();
    String getAbbreviationSrb();
    String getAbbreviationEng();
    String getAbbreviationOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getNote();
    String getUri();
    String getScopusID();
    String getCobissID();
    String getEcrisID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    JournalStatus getJournalStatus();
    Language getLanguage();
    Publisher getPublisher();
}