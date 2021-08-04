package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperProceedingsStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperProceedingsStatusProjection", types = {PaperProceedingsStatus.class})
public interface PaperProceedingsStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
