package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonName;
import com.ftninformatika.cris.model.projection.PersonNameProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonNameProjection.class)
public interface PersonNameRepository extends PagingAndSortingRepository<PersonName, Long> {

    //Bez person
    @RestResource(path = "search", rel = "search")
    List<PersonName> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName);

    //Sa person
    @RestResource(path = "search1", rel = "search3")
    List<PersonName> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("personId") Long personId);
}