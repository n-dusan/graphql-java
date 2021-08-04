package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ProductType;
import com.ftninformatika.cris.model.projection.ProductTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ProductTypeProjection.class)
public interface ProductTypeRepository extends PagingAndSortingRepository<ProductType, Long> {

    @RestResource(path = "search", rel = "search")
    List<ProductType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
