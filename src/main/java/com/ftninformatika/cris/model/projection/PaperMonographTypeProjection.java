package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperMonographType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperMonographTypeProjection", types = {PaperMonographType.class})
public interface PaperMonographTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
