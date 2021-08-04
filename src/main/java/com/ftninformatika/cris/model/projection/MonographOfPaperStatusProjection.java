package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.MonographOfPaperStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MonographOfPaperStatusProjection", types = {MonographOfPaperStatus.class})
public interface MonographOfPaperStatusProjection {

    Long getId();
    String getName();
    String getDescription();

}
