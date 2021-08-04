package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.Monograph;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "MonographProjection", types = {Monograph.class})
public interface MonographProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getVolumeCode();
    String getVolumeTitle();
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
    String getCobissID();
    String getScopusID();
    String getEcrisID();
    String getUri();
    String getYear();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Language getLanguage();
}