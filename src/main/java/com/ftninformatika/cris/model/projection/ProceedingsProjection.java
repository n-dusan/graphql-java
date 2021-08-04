package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Conference;
import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.Proceedings;
import com.ftninformatika.cris.model.Publisher;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Projection(name = "ProceedingsProjection", types = {Proceedings.class})
public interface ProceedingsProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getIsbn();
    Integer getNumberOfPages();
    String getDimension();
    String getEditionTitle();
    Integer getEditionNumber();
    String getNameAbbreviationSrb();
    String getNameAbbreviationEng();
    String getNameAbbreviationOth();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getNote();
    String getUri();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Conference getConference();
    Language getLanguage();
    Publisher getPublisher();
}