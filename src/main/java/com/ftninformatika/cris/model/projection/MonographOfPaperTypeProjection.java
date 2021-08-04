package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.MonographOfPaperType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "MonographOfPaperTypeProjection", types = {MonographOfPaperType.class})
public interface MonographOfPaperTypeProjection {

    Long getId();
    String getName();
    String getDescription();

}
