package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PatentStatus;
import com.ftninformatika.cris.model.projection.PatentStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PatentStatusProjection.class)
public interface PatentStatusRepository extends PagingAndSortingRepository<PatentStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<PatentStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
