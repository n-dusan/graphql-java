package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ProductStatus;
import com.ftninformatika.cris.model.projection.ProductStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ProductStatusProjection.class)
public interface ProductStatusRepository extends PagingAndSortingRepository<ProductStatus, Long>{

    @RestResource(path = "search", rel = "search")
    List<ProductStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
