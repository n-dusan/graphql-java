package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.License;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "LicenseProjection", types = {License.class})
public interface LicenseProjection {

    Long getId();
    String getName();
    String getDescription();
}
