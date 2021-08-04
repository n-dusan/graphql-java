package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.PersonType;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "PersonProjection", types = {Person.class})
public interface PersonProjection {

    Long getId();
    String getFirstName();
    String getLastName();
    String getMiddleName();
    LocalDate getDateOfBirth();
    String getPlaceOfBirth();
    String getState();
    String getAddress();
    String getCity();
    String getBibliographySrb();
    String getBibliographyEng();
    String getBibliographyOth();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getGender();
    String getUri();
    String getEmail();
    String getOrcid();
    String getScopusID();
    String getCobissID();
    String getEcrisID();
    String getDspaceRecordID();
    String getJmbg();
    String getPhones();
    String getResearchAreas();
    String getMntrn();
    String getNote();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Boolean getAlreadyRegistered();
    Language getLanguage();
    PersonType getPersonType();

}