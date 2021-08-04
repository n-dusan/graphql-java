package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionFounder;
import com.ftninformatika.cris.model.Journal;
import com.ftninformatika.cris.model.projection.JournalProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = JournalProjection.class)
public interface JournalRepository extends PagingAndSortingRepository<Journal, Long> {

    Journal findByEissnAndPissn(@Param("eissn") String eissn, @Param("pissn") String pissn);
    Journal findByEissn(@Param("eissn") String eissn);
    Journal findByPissn(@Param("pissn") String pissn);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();
}
