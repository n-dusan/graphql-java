package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.JournalStatus;
import com.ftninformatika.cris.model.projection.JournalStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/24/2017.
 */
@RepositoryRestResource(excerptProjection = JournalStatusProjection.class)
public interface JournalStatusRepository extends PagingAndSortingRepository<JournalStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<JournalStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);
}
