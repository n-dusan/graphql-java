package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Activity;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ActivitiyProjection", types = {Activity.class})
public interface ActivitiyProjection {

    Long getId();
    String getCode();
    String getName();
    String getDescription();
}
