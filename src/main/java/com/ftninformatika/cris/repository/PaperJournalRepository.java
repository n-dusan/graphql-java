package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperJournal;
import com.ftninformatika.cris.model.projection.PaperJournalProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

@RepositoryRestResource(excerptProjection = PaperJournalProjection.class)
public interface PaperJournalRepository extends PagingAndSortingRepository<PaperJournal, Long> {

    PaperJournal findByScopusID(@Param("scopusID") String scopusID);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
