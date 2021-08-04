package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Project;
import com.ftninformatika.cris.model.ProjectStatus;
import com.ftninformatika.cris.model.ProjectType;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Projection(name = "ProjectProjection", types = {Project.class})
public interface ProjectProjection {

    Long getId();
    String getTitleSrb();
    String getTitleEng();
    String getTitleOth();
    String getAbstractSrb();
    String getAbstractEng();
    String getAbstractOth();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    LocalDate getStartDate();
    LocalDate getEndDate();
    String getAcronym();
    String getUri();
    String getDspaceRecordID();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getMntrn();
    String getNote();
    String getModifier();
    String getCreator();
    LocalDateTime getCreationDate();
    LocalDateTime getLastModificationDate();
    Integer getRecordStatus();
    ProjectStatus getProjectStatus();
    ProjectType getProjectType();
}