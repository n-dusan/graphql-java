package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperJournalStatus;
import com.ftninformatika.cris.model.projection.PaperJournalStatusProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

/**
 * Created by Alek on 7/24/2017.
 */
@RepositoryRestResource(excerptProjection = PaperJournalStatusProjection.class)
public interface PaperJournalStatusRepository extends PagingAndSortingRepository<PaperJournalStatus, Long> {

    @RestResource(path = "search", rel = "search")
    List<PaperJournalStatus> findByNameContainingAndDescriptionContainingAllIgnoreCase(
            @Param("name") String name,
            @Param("description") String description);

}
