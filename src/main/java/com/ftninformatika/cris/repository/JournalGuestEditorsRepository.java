package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.JournalGuestEditors;
import com.ftninformatika.cris.model.projection.JournalGuestEditorsProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = JournalGuestEditorsProjection.class)
public interface JournalGuestEditorsRepository extends PagingAndSortingRepository<JournalGuestEditors, Long> {

    //Bez numberOfGuestEditors i person
    @RestResource(path = "search", rel = "search")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa numberOfGuestEditors i person
    @RestResource(path = "search1", rel = "search1")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndNumberOfGuestEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("numberOfGuestEditors") Integer numberOfGuestEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);

    //Sa numberOfGuestEditors
    @RestResource(path = "search2", rel = "search2")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndNumberOfGuestEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("numberOfGuestEditors") Integer numberOfGuestEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations);

    //Sa person
    @RestResource(path = "search3", rel = "search3")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndPersonIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("personId") Long personId);


    //METODE ISPOD SU ISTE KAO I OVE IZNAD ALI IMAJU journalId

    //Bez numberOfGuestEditors i person
    @RestResource(path = "search4", rel = "search4")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId);

    //Sa numberOfGuestEditors i person
    @RestResource(path = "search5", rel = "search5")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndNumberOfGuestEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAndPersonIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("numberOfGuestEditors") Integer numberOfGuestEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId,
            @Param("personId") Long personId);

    //Sa numberOfGuestEditors
    @RestResource(path = "search6", rel = "search6")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndNumberOfGuestEditorsAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("numberOfGuestEditors") Integer numberOfGuestEditors,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId);

    //Sa person
    @RestResource(path = "search7", rel = "search7")
    List<JournalGuestEditors> findByYearContainingAndVolumeContainingAndNumberContainingAndFirstNameContainingAndLastNameContainingAndMiddleNameContainingAndEmailContainingAndAffiliationsContainingAndJournalIdAndPersonIdAllIgnoreCase(
            @Param("year") String year,
            @Param("volume") String volume,
            @Param("number") String number,
            @Param("firstName") String firstName,
            @Param("lastName") String lastName,
            @Param("middleName") String middleName,
            @Param("email") String email,
            @Param("affiliations") String affiliations,
            @Param("journalId") Long journalId,
            @Param("personId") Long personId);

}