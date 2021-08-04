package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.MonographOfPaperStatus;
import com.ftninformatika.cris.model.MonographOfPaperType;
import com.ftninformatika.cris.model.MonographOfPapers;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "MonographOfPapersProjection", types = {MonographOfPapers.class})
public interface MonographOfPapersProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getIsbn();
    Integer getNumberOfPages();
    String getEditionTitle();
    Integer getEditionNumber();
    String getEditionPISSN();
    String getEditionEISSN();
    Boolean getTranslated();
    String getNote();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getDspaceRecordID();
    String getUri();
    String getYear();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    MonographOfPaperStatus getMonographOfPaperStatus();
    MonographOfPaperType getMonographOfPaperType();
}