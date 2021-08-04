package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.MonographEditors;
import com.ftninformatika.cris.model.projection.MonographEditorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = MonographEditorsProjection.class)
public interface MonographEditorsRepository extends PagingAndSortingRepository<MonographEditors, Long>{

    //Bez numOrder i person
    @RestResource(path = "search", rel = "search")
    List<MonographEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa numOrder i person
    @RestResource(path = "search1", rel = "search1")
    List<MonographEditors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search2", rel = "search2")
    List<MonographEditors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<MonographEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);


    //METODE ISPOD SU ISTE KAO I OVE IZNAD ALI IMAJU monographOfPapersId

    //Bez numOrder i person
    @RestResource(path = "search4", rel = "search")
    List<MonographEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndMonographOfPapersIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("monographOfPapersId") Long monographOfPapersId);

    //Sa numOrder i person
    @RestResource(path = "search5", rel = "search1")
    List<MonographEditors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndMonographOfPapersIdAndPersonIdAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("monographOfPapersId") Long monographOfPapersId,
            @Param("personId") Long personId);

    //Sa numOrder
    @RestResource(path = "search6", rel = "search2")
    List<MonographEditors> findByNumOrderAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndMonographOfPapersIdAllIgnoreCase(
            @Param("numOrder") Integer numOrder,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("monographOfPapersId") Long monographOfPapersId);

    //Sa person
    @RestResource(path = "search7", rel = "search3")
    List<MonographEditors> findByFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndMonographOfPapersIdAndPersonIdAllIgnoreCase(
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("monographOfPapersId") Long monographOfPapersId,
            @Param("personId") Long personId);

}
