package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ThesisStatus;
import com.ftninformatika.cris.model.projection.ThesisStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/25/2017.
 */
@RepositoryRestResource(excerptProjection = ThesisStatusProjection.class)
public interface ThesisStatusRepository extends PagingAndSortingRepository<ThesisStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<ThesisStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}