package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PaperMonographAuthors;
import com.ftninformatika.cris.model.projection.PaperMonographAuthorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PaperMonographAuthorsProjection.class)
public interface PaperMonographAuthorsRepository extends PagingAndSortingRepository<PaperMonographAuthors, Long> {

    //Bez numOrder i person
    @RestResource(path = "search", rel = "search")
    List<PaperMonographAuthors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa numOrder i person
    @RestResource(path = "search1", rel = "search1")
    List<PaperMonographAuthors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search2", rel = "search2")
    List<PaperMonographAuthors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<PaperMonographAuthors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);
}