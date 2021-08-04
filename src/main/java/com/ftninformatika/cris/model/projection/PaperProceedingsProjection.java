package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "PaperProceedingsProjection", types = {PaperProceedings.class})
public interface PaperProceedingsProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getSubtitleSrb();
    String getSubtitleEng();
    String getSubtitleOth();
    String getStartPage();
    String getEndPage();
    Integer getNumberOfPages();
    String getNote();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getUri();
    String getDspaceRecordID();
    String getscopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    Language getLanguage();
    PaperProceedingsType getPaperProceedingsType();
    PaperProceedingsStatus getPaperProceedingsStatus();
    Proceedings getProceedings();
}