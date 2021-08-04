package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperProceedingsType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperProceedingsTypeProjection", types = {PaperProceedingsType.class})
public interface PaperProceedingsTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
