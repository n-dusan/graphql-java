package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.TitleInstitution;
import com.ftninformatika.cris.model.projection.TitleInstitutionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = TitleInstitutionProjection.class)
public interface TitleInstitutionRepository extends PagingAndSortingRepository<TitleInstitution, Long> {

    //Bez institution i person
    @RestResource(path = "search", rel = "search")
    List<TitleInstitution> findByTitleContainingAndYearContainingAllIgnoreCase(
            @Param("title") String title,
            @Param("year") String year);

    //Sa institution i person
    @RestResource(path = "search1", rel = "search1")
    List<TitleInstitution> findByTitleContainingAndYearContainingAndInstitutionIdAndPersonIdAllIgnoreCase(
            @Param("title") String title,
            @Param("year") String year,
            @Param("institutionId") Long institutionId,
            @Param("personId") Long personId);

    //Sa institution
    @RestResource(path = "search2", rel = "search2")
    List<TitleInstitution> findByTitleContainingAndYearContainingAndInstitutionIdAllIgnoreCase(
            @Param("title") String title,
            @Param("year") String year,
            @Param("institutionId") Long institutionId);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<TitleInstitution> findByTitleContainingAndYearContainingAndPersonIdAllIgnoreCase(
            @Param("title") String title,
            @Param("year") String year,
            @Param("personId") Long personId);

}