package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.PaperMonographStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PaperMonographStatusProjection", types = {PaperMonographStatus.class})
public interface PaperMonographStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
