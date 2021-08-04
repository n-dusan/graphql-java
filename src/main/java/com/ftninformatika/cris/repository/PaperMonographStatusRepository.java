package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperMonographStatus;
import com.ftninformatika.cris.model.projection.PaperMonographStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PaperMonographStatusProjection.class)
public interface PaperMonographStatusRepository extends PagingAndSortingRepository<PaperMonographStatus, Long>{

    @RestResource(path = "search", rel = "search")
    List<PaperMonographStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}