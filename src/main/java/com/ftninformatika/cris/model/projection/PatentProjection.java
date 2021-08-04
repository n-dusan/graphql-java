package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "PatentProjection", types = {Patent.class})
public interface PatentProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getNumber();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getUri();
    String getDspaceRecordID();
    String getYear();
    String getScopusID();
    String getCobissID();
    String getEcrisID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Language getLanguage();
    PatentStatus getPatentStatus();
    PatentType getPatentType();
    Publisher getPublisher();
}