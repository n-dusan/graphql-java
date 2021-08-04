package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.*;
import java.time.LocalDateTime;

@Projection(name = "ThesisProjection", types = {Thesis.class})
public interface ThesisProjection {
    
    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getStudyType();
    String getUri();
    String getDspaceRecordID();
    String getYear();
    Integer getNumberOfPages();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Institution getInstitution();
    Commission getCommission();
    Language getLanguage();
    Person getPerson();
    Publisher getPublisher();
    ThesisStatus getThesisStatus();
    ThesisType getThesisType();

}
