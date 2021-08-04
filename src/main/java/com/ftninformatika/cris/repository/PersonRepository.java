package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Person;
import com.ftninformatika.cris.model.projection.PersonProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonProjection.class)
public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Person findByScopusID(@Param("scopusID") String scopusID);

    @RestResource(path = "count", rel = "count")
    Integer countByIdNotNull();

    @RestResource(path = "search", rel = "search")
    Page<Person> findByFirstNameContainingAndLastNameContainingAndEmailContainingAndScopusIDContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("email") String email,
            @Param("scopusID") String scopusID,
            Pageable page);




}
