package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Language;
import com.ftninformatika.cris.model.ResearchArea;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "FounderProjection", types = {ResearchArea.class})
public interface ResearchAreaProjection {

    Long getId();
    String getName();
    String getDescription();
    Language getLanguage();
}