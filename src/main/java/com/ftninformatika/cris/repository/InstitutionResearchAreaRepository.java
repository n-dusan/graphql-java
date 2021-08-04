package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionResearchArea;
import com.ftninformatika.cris.model.projection.InstitutionResearchAreaProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = InstitutionResearchAreaProjection.class)
public interface InstitutionResearchAreaRepository extends PagingAndSortingRepository<InstitutionResearchArea, Long>{

    //Bez Institution i ResearchArea
    @RestResource(path = "search", rel = "search")
    List<InstitutionResearchArea> findByNoteContainingAllIgnoreCase(
            @Param("note") String note);

    //Sa Institution i ResearchArea
    @RestResource(path = "search1", rel = "search1")
    List<InstitutionResearchArea> findByNoteContainingAndInstitutionIdAndResearchAreaIdAllIgnoreCase(
            @Param("note") String note,
            @Param("institutionId") Long institutionId,
            @Param("researchAreaId") Long researchAreaId);

    //Sa Institution
    @RestResource(path = "search2", rel = "search2")
    List<InstitutionResearchArea> findByNoteContainingAndInstitutionIdAllIgnoreCase(
            @Param("note") String note,
            @Param("institutionId") Long institutionId);

    //Sa ResearchArea
    @RestResource(path = "search3", rel = "search3")
    List<InstitutionResearchArea> findByNoteContainingAndResearchAreaIdAllIgnoreCase(
            @Param("note") String note,
            @Param("researchAreaId") Long researchAreaId);

    //Samo sa id-jem institucije bez note
    @RestResource(path = "searchByInstId", rel = "searchByInstId")
    List<InstitutionResearchArea> findByInstitutionId(@Param("institutionId") Long institutionId);

}
