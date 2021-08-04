package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Conference;
import com.ftninformatika.cris.model.projection.ConferenceProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ConferenceProjection.class)
public interface ConferenceRepository extends PagingAndSortingRepository<Conference, Long> {

    //Sa RecordStatus-om i Language
    @RestResource(path = "search2", rel = "search2")
    List<Conference> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndPlaceContainingAndYearContainingAndPeriodContainingAndNumberContainingAndStateContainingAndFeeContainingAndDescriptionContainingAndDescriptionEngContainingAndDescriptionOthContainingAndKeywordsContainingAndKeywordsEngContainingAndKeywordsOthContainingAndUriContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndCreatorContainingAndModifierContainingAndRecordStatusAndLanguageIdAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("place") String place,
            @Param("year") String year,
            @Param("period") String period,
            @Param("number") String number,
            @Param("state") String state,
            @Param("fee") String fee,
            @Param("description") String description,
            @Param("descriptionEng") String descriptionEng,
            @Param("descriptionOth") String descriptionOth,
            @Param("keywords") String keywords,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("uri") String uri,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus") Integer recordStatus,
            @Param("languageId") Long languageId);

    //Sa RecordStatus-om
    @RestResource(path = "search3", rel = "search3")
    List<Conference> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndPlaceContainingAndYearContainingAndPeriodContainingAndNumberContainingAndStateContainingAndFeeContainingAndDescriptionContainingAndDescriptionEngContainingAndDescriptionOthContainingAndKeywordsContainingAndKeywordsEngContainingAndKeywordsOthContainingAndUriContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndCreatorContainingAndModifierContainingAndRecordStatusAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("place") String place,
            @Param("year") String year,
            @Param("period") String period,
            @Param("number") String number,
            @Param("state") String state,
            @Param("fee") String fee,
            @Param("description") String description,
            @Param("descriptionEng") String descriptionEng,
            @Param("descriptionOth") String descriptionOth,
            @Param("keywords") String keywords,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("uri") String uri,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus") Integer recordStatus);

    //Sa Language
    @RestResource(path = "search4", rel = "search4")
    List<Conference> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndPlaceContainingAndYearContainingAndPeriodContainingAndNumberContainingAndStateContainingAndFeeContainingAndDescriptionContainingAndDescriptionEngContainingAndDescriptionOthContainingAndKeywordsContainingAndKeywordsEngContainingAndKeywordsOthContainingAndUriContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndCreatorContainingAndModifierContainingAndLanguageIdAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("place") String place,
            @Param("year") String year,
            @Param("period") String period,
            @Param("number") String number,
            @Param("state") String state,
            @Param("fee") String fee,
            @Param("description") String description,
            @Param("descriptionEng") String descriptionEng,
            @Param("descriptionOth") String descriptionOth,
            @Param("keywords") String keywords,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("uri") String uri,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("languageId") Long languageId);

    //Bez RecordStatus i Language
    @RestResource(path = "search", rel = "search")
    List<Conference> findByNameSrbContainingAndNameEngContainingAndNameOthContainingAndPlaceContainingAndYearContainingAndPeriodContainingAndNumberContainingAndStateContainingAndFeeContainingAndDescriptionContainingAndDescriptionEngContainingAndDescriptionOthContainingAndKeywordsContainingAndKeywordsEngContainingAndKeywordsOthContainingAndUriContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndCreatorContainingAndModifierContainingAllIgnoreCase(
            @Param("nameSrb") String nameSrb,
            @Param("nameEng") String nameEng,
            @Param("nameOth") String nameOth,
            @Param("place") String place,
            @Param("year") String year,
            @Param("period") String period,
            @Param("number") String number,
            @Param("state") String state,
            @Param("fee") String fee,
            @Param("description") String description,
            @Param("descriptionEng") String descriptionEng,
            @Param("descriptionOth") String descriptionOth,
            @Param("keywords") String keywords,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("uri") String uri,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("creator") String creator,
            @Param("modifier") String modifier);
}
