package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "PaperJournalProjection", types = {PaperJournal.class})
public interface PaperJournalProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getStartPage();
    String getEndPage();
    String getVolume();
    String getNumber();
    String getNote();
    String getKeywords();
    String getKeywordsEng();
    String getKeywordsOth();
    String getApstract();
    String getAbstractEng();
    String getAbstractOth();
    String getUri();
    String getDoi();
    String getScopusID();
    String getCobissID();
    String getYear();
    String getDspaceRecordID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    PaperJournalType getPaperJournalType();
    PaperJournalStatus getPaperJournalStatus();
    Journal getJournal();
    Language getLanguage();
}