package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ProductStatus;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProductStatusProjection", types = {ProductStatus.class})
public interface ProductStatusProjection {

    Long getId();
    String getName();
    String getDescription();
}
