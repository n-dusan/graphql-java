package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.ProceedingsEditors;
import com.ftninformatika.cris.model.projection.ProceedingsEditorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ProceedingsEditorsProjection.class)
public interface ProceedingsEditorsRepository extends PagingAndSortingRepository<ProceedingsEditors, Long> {

    //Bez proceedings i person
    @RestResource(path = "search", rel = "search")
    List<ProceedingsEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa proceedongs i person
    @RestResource(path = "search1", rel = "search1")
    List<ProceedingsEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndProceedingsIdAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("proceedingsId") Long proceedingsId,
            @Param("personId") Long personId);

    //Sa proceedongs
    @RestResource(path = "search2", rel = "search2")
    List<ProceedingsEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndProceedingsIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("proceedingsId") Long proceedingsId);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<ProceedingsEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

}