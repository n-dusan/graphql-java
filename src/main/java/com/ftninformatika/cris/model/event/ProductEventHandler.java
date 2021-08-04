package com.ftninformatika.cris.model.event;

import com.ftninformatika.cris.model.Product;
import org.springframework.data.rest.core.annotation.HandleBeforeCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import java.time.LocalDateTime;

@RepositoryEventHandler(Product.class)
public class ProductEventHandler {

    @HandleBeforeCreate
    public void handleProductCreation(Product product) {
        if (product.getCreationDate() == null) {
            product.setCreationDate(LocalDateTime.now());
        } else {
            product.setLastModificationDate(LocalDateTime.now());
        }
    }
}