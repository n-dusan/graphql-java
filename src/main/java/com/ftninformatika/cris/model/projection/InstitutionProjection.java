package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Institution;
import com.ftninformatika.cris.model.InstitutionStatus;
import com.ftninformatika.cris.model.InstitutionType;
import com.ftninformatika.cris.model.Language;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "InstitutionProjection", types = {Institution.class})
public interface InstitutionProjection {

    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getAddress();
    String getPlace();
    String getPostalCode();
    String getAcro();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getUri();
    String getEmail();
    String getPhone();
    String getPib();
    String getMaticniBroj();
    String getBankAccount();
    String getEcrisID();
    String getNioID();
    String getMntrID();
    String getOrcid();
    String getScopusID();
    String getDspaceRecordID();
    String getNote();
    String getAccreditationNumber();
    LocalDate getAccreditationDate();
    String getAccreditationNote();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Language getLanguage();
    InstitutionStatus getInstitutionStatus();
    InstitutionType getInstitutionType();
    Institution getSuperInstitution();
}