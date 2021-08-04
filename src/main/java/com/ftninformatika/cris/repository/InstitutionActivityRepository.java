package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.InstitutionActivity;
import com.ftninformatika.cris.model.projection.InstitutionActivityProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = InstitutionActivityProjection.class)
public interface InstitutionActivityRepository extends PagingAndSortingRepository<InstitutionActivity, Long>{

    //Bez Institution i Activity
    @RestResource(path = "search", rel = "search")
    List<InstitutionActivity> findByNoteContainingAllIgnoreCase(
            @Param("note") String note);

    //Sa Institution i Activity
    @RestResource(path = "search1", rel = "search1")
    List<InstitutionActivity> findByNoteContainingAndInstitutionIdAndActivityIdAllIgnoreCase(
            @Param("note") String note,
            @Param("institutionId") Long institutionId,
            @Param("activityId") Long activityId);

    //Sa Institution
    @RestResource(path = "search2", rel = "search2")
    List<InstitutionActivity> findByNoteContainingAndInstitutionIdAllIgnoreCase(
            @Param("note") String note,
            @Param("institutionId") Long institutionId);

    //Sa Activity
    @RestResource(path = "search3", rel = "search3")
    List<InstitutionActivity> findByNoteContainingAndActivityIdAllIgnoreCase(
            @Param("note") String note,
            @Param("activityId") Long activityId);

}
