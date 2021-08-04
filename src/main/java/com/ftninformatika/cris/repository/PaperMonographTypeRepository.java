package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperMonographType;
import com.ftninformatika.cris.model.projection.PaperMonographTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PaperMonographTypeProjection.class)
public interface PaperMonographTypeRepository extends PagingAndSortingRepository<PaperMonographType, Long> {

    @RestResource(path = "search", rel = "search")
    List<PaperMonographType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
