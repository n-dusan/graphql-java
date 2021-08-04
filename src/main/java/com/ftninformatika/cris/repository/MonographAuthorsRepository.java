package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.MonographAuthors;
import com.ftninformatika.cris.model.projection.MonographAuthorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = MonographAuthorsProjection.class)
public interface MonographAuthorsRepository extends PagingAndSortingRepository<MonographAuthors, Long>{

    //Bez numOrder i person
    @RestResource(path = "search", rel = "search")
    List<MonographAuthors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa numOrder i person
    @RestResource(path = "search1", rel = "search1")
    List<MonographAuthors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search2", rel = "search2")
    List<MonographAuthors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<MonographAuthors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

}
