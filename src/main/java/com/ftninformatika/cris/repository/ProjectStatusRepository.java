package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ProjectStatus;
import com.ftninformatika.cris.model.projection.ProjectStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/25/2017.
 */
@RepositoryRestResource(excerptProjection = ProjectStatusProjection.class)
public interface ProjectStatusRepository extends PagingAndSortingRepository<ProjectStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<ProjectStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}