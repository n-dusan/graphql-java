package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Partner;
import com.ftninformatika.cris.model.projection.PartnerProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = PartnerProjection.class)
public interface PartnerRepository extends PagingAndSortingRepository<Partner, Long> {

    //Sa numOrder i institution
    @RestResource(path = "search1", rel = "search1")
    List<Partner> findByNumOrderAndInstitutionId(
            @Param("numOrder") Integer numOrder,
            @Param("institutionId") Long institutionId);

    //Sa numOrder
    @RestResource(path = "search2", rel = "search2")
    List<Partner> findByNumOrder(
            @Param("numOrder") Integer numOrder);

    //Sa institution
    @RestResource(path = "search3", rel = "search3")
    List<Partner> findByInstitutionId(
            @Param("institutionId") Long institutionId);


    //METODE ISPOD SU ISTE KAO I OVE IZNAD ALI IMAJU projectId

    //Bez numOrder i institution
    @RestResource(path = "search4", rel = "search")
    List<Partner> findByProjectId(
            @Param("projectId") Long projectId);

    //Sa numOrder i institution
    @RestResource(path = "search5", rel = "search1")
    List<Partner> findByNumOrderAndProjectIdAndInstitutionId(
            @Param("numOrder") Integer numOrder,
            @Param("projectId") Long projectId,
            @Param("institutionId") Long institutionId);

    //Sa numOrder
    @RestResource(path = "search6", rel = "search2")
    List<Partner> findByNumOrderAndProjectId(
            @Param("numOrder") Integer numOrder,
            @Param("projectId") Long projectId);

    //Sa institution
    @RestResource(path = "search7", rel = "search3")
    List<Partner> findByProjectIdAndInstitutionId(
            @Param("projectId") Long projectId,
            @Param("institutionId") Long institutionId);

}