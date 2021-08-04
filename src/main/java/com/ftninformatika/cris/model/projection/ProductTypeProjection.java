package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.ProductType;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "ProductTypeProjection", types = {ProductType.class})
public interface ProductTypeProjection {

    Long getId();
    String getName();
    String getDescription();
}
