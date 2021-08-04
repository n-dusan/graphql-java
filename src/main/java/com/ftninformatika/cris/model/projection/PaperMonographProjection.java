package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "PaperMonographProjection", types = {PaperMonograph.class})
public interface PaperMonographProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getStartPage();
    String getEndPage();
    String getNote();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getUri();
    String getDspaceRecordID();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    PaperMonographType getPaperMonographType();
    PaperMonographStatus getPaperMonographStatus();
    Language getLanguage();
    MonographOfPapers getMonographOfPapers();
}