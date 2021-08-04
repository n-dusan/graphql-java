package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "FileProjection", types = {File.class})
public interface FileProjection {

    Long getId();
    String getDspaceFileID();
    String getNote();
    String getDoi();
    License getLicense();
    Institution getInstitution();
    PaperJournal  getPaperJournal();
    PaperMonograph getPaperMonograph();
    PaperProceedings getPaperProceedings();
    Patent getPatent();
    Person getPerson();
    Product getProduct();
    Project getProject();
    Thesis getThesis();
}