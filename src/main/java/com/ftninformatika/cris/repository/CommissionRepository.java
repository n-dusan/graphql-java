package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Commission;
import com.ftninformatika.cris.model.projection.CommissionProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = CommissionProjection.class)
public interface CommissionRepository extends PagingAndSortingRepository<Commission, Long> {

    //Sa Person i ordNum
    @RestResource(path = "search1", rel = "search1")
    List<Commission> findByOrdNumAndPersonId(
            @Param("ordNum") Integer ordNum,
            @Param("personId") Long personId);

    //Sa Person
    @RestResource(path = "search2", rel = "search2")
    List<Commission> findByPersonId(
            @Param("personId") Long personId);

    //Sa ordNum
    @RestResource(path = "search3", rel = "search3")
    List<Commission> findByOrdNum(
            @Param("ordNum") Integer ordNum);

}
