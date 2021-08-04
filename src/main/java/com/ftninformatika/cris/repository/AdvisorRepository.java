package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Advisor;
import com.ftninformatika.cris.model.projection.AdvisorProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = AdvisorProjection.class)
public interface AdvisorRepository extends PagingAndSortingRepository<Advisor, Long> {

    //Sa numOrder i person
    @RestResource(path = "search1", rel = "search1")
    List<Advisor> findByNumOrderAndPersonId(
            @Param("numOrder") Integer numOrder,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search2", rel = "search2")
    List<Advisor> findByNumOrder(
            @Param("numOrder") Integer numOrder);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<Advisor> findByPersonId(
            @Param("personId") Long personId);


    //METODE ISPOD SU ISTE KAO I OVE IZNAD ALI IMAJU thesisId

    //Bez numOrder i person
    @RestResource(path = "search4", rel = "search")
    List<Advisor> findByThesisId(
            @Param("thesisId") Long thesisId);

    //Sa numOrder i person
    @RestResource(path = "search5", rel = "search1")
    List<Advisor> findByNumOrderAndThesisIdAndPersonId(
            @Param("numOrder") Integer numOrder,
            @Param("thesisId") Long thesisId,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search6", rel = "search2")
    List<Advisor> findByNumOrderAndThesisId(
            @Param("numOrder") Integer numOrder,
            @Param("thesisId") Long thesisId);

    //Sa person
    @RestResource(path = "search7", rel = "search3")
    List<Advisor> findByThesisIdAndPersonId(
            @Param("thesisId") Long thesisId,
            @Param("personId") Long personId);

}