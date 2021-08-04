package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.Partner;
import com.ftninformatika.cris.model.PartnerRole;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "PartnerRoleProjection", types = {PartnerRole.class})
public interface PartnerRoleProjection {

    Long getId();
    String getName();
    String getDescription();
    Partner getPartner();
}
