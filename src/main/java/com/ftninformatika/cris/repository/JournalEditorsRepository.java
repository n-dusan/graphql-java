package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.JournalEditors;
import com.ftninformatika.cris.model.projection.JournalEditorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = JournalEditorsProjection.class)
public interface JournalEditorsRepository extends PagingAndSortingRepository<JournalEditors, Long> {

    //Bez numberOfEditors i person
    @RestResource(path = "search", rel = "search")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa numberOfEditors i person
    @RestResource(path = "search1", rel = "search1")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndNumberOfEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("numberOfEditors") Integer numberOfEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

    //Sa numberOfEditors
    @RestResource(path = "search2", rel = "search2")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndNumberOfEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("numberOfEditors") Integer numberOfEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);


    //METODE ISPOD SU ISTE KAO I OVE IZNAD ALI IMAJU journalId

    //Bez numberOfEditors i person
    @RestResource(path = "search4", rel = "search4")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId);

    //Sa numberOfEditors i person
    @RestResource(path = "search5", rel = "search5")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndNumberOfEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAndPersonIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("numberOfEditors") Integer numberOfEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId,
            @Param("personId") Long personId);

    //Sa numberOfEditors
    @RestResource(path = "search6", rel = "search6")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndNumberOfEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("numberOfEditors") Integer numberOfEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId);

    //Sa person
    @RestResource(path = "search7", rel = "search7")
    List<JournalEditors> findByStartYearContainingAndStartVolumeContainingAndStartNumberContainingAndEndYearContainingAndEndVolumeContainingAndEndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAndPersonIdAllIgnoreCase(
            @Param("startYear") String startYear,
            @Param("startVolume") String startVolume,
            @Param("startNumber") String startNumber,
            @Param("endYear") String endYear,
            @Param("endVolume") String endVolume,
            @Param("endNumber") String endNumber,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId,
            @Param("personId") Long personId);

}
