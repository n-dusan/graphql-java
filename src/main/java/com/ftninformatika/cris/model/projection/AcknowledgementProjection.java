package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "AcknowledgementProjection", types = {Acknowledgement.class})
public interface AcknowledgementProjection {

    Long getId();
    String getText();
    Project getProject();
    PaperJournal getPaperJournal();
    PaperMonograph getPaperMonograph();
    PaperProceedings getPaperProceedings();
    Patent getPatent();
    Product getProduct();
    Thesis getThesis();
}