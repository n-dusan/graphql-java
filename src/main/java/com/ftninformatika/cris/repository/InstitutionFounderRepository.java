package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionFounder;
import com.ftninformatika.cris.model.projection.InstitutionFounderProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = InstitutionFounderProjection.class)
public interface InstitutionFounderRepository extends PagingAndSortingRepository<InstitutionFounder, Long>{

    //Bez Institution i Founder
    @RestResource(path = "search", rel = "search")
    List<InstitutionFounder> findByRescriptNumberContainingAllIgnoreCase(
            @Param("rescriptNumber") String rescriptNumber);

    //Sa Institution i Founder
    @RestResource(path = "search1", rel = "search1")
    List<InstitutionFounder> findByRescriptNumberContainingAndInstitutionIdAndFounderIdAllIgnoreCase(
            @Param("rescriptNumber") String rescriptNumber,
            @Param("institutionId") Long institutionId,
            @Param("founderId") Long founderId);

    //Sa Institution
    @RestResource(path = "search2", rel = "search2")
    List<InstitutionFounder> findByRescriptNumberContainingAndInstitutionIdAllIgnoreCase(
            @Param("rescriptNumber") String rescriptNumber,
            @Param("institutionId") Long institutionId);

    //Sa Founder
    @RestResource(path = "search3", rel = "search3")
    List<InstitutionFounder> findByRescriptNumberContainingAndFounderIdAllIgnoreCase(
            @Param("rescriptNumber") String rescriptNumber,
            @Param("founderId") Long founderId);
}
