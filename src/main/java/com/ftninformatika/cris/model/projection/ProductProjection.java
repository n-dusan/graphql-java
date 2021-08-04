package com.ftninformatika.cris.model.projection;

import com.ftninformatika.cris.model.*;
import org.springframework.data.rest.core.config.Projection;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Projection(name = "ProductProjection", types = {Product.class})
public interface ProductProjection {

    Long getId();
    String getNameSrb();
    String getNameEng();
    String getNameOth();
    String getInternalNumber();
    String getKeywordsSrb();
    String getKeywordsEng();
    String getKeywordsOth();
    String getDescriptionSrb();
    String getDesriptionEng();
    String getDescriptionOth();
    String getUri();
    String getDspaceRecordID();
    String getYear();
    String getScopusID();
    String getEcrisID();
    String getCobissID();
    String getCreator();
    String getModifier();
    Integer getRecordStatus();
    Language getLanguage();
    ProductStatus getProductStatus();
    ProductType getProductType();
    Publisher getPublisher();
}