package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ProjectType;
import com.ftninformatika.cris.model.projection.ProjectTypeProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/26/2017.
 */
@RepositoryRestResource(excerptProjection = ProjectTypeProjection.class)
public interface ProjectTypeRepository extends PagingAndSortingRepository<ProjectType, Long> {

    @RestResource(path = "search", rel = "search")
    List<ProjectType> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
