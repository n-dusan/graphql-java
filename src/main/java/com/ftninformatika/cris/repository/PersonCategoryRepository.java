package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.PersonCategory;
import com.ftninformatika.cris.model.projection.PersonCategoryProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PersonCategoryProjection.class)
public interface PersonCategoryRepository extends PagingAndSortingRepository<PersonCategory, Long> {

    //Sa category i person
    @RestResource(path = "search1", rel = "search1")
    List<PersonCategory> findByCategoryIdAndPersonId(
            @Param("categoryId") Long categoryId,
            @Param("personId") Long personId);

    //Sa category
    @RestResource(path = "search2", rel = "search2")
    List<PersonCategory> findByCategoryId(
            @Param("categoryId") Long categoryId);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<PersonCategory> findByPersonId(
            @Param("personId") Long personId);
}