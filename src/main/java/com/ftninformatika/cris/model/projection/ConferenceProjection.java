package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Conference;
import com.ftninformatika.cris.model.Language;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "ConferenceProjection", types = {Conference.class})
public interface ConferenceProjection {
    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getPlace();
    String getYear();
    String getPeriod();
    String getNumber();
    String getState();
    String getFee();
    String getDescription();
    String getDescriptionEng();
    String getDescriptionOth();
    String getKeywords();
    String getKeywordsEng();
    String getKeywordsOth();
    String getUri();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Language getLanguage();
}