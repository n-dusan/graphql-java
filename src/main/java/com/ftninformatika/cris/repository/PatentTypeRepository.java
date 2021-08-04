package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PatentType;
import com.ftninformatika.cris.model.projection.PatentTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PatentTypeProjection.class)
public interface PatentTypeRepository extends PagingAndSortingRepository<PatentType, Long> {

    @RestResource(path = "search", rel = "search")
    List<PatentType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
