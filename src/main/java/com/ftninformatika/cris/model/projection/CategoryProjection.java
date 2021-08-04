package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Category;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "CategoryProjection", types = {Category.class})
public interface CategoryProjection {

    Long getId();
    String getName();
    String getDescription();
}
