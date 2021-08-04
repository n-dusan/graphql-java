package com.ftninformatika.cris.repository;

import com.ftninformatika.cris.model.Project;
import com.ftninformatika.cris.model.projection.ProjectProjection;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

@RepositoryRestResource(excerptProjection = ProjectProjection.class)
public interface ProjectRepository extends PagingAndSortingRepository<Project, Long> {

    //Bez RecordStatus-a, ProjectStatus-a i ProjectType-a
    @RestResource(path = "search", rel = "search")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier);

    //Sa RecordStatus-om
    @RestResource(path = "search2", rel = "search2")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndRecordStatusAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus")Integer recordStatus);

    //Sa RecordStatus-om i ProjectStatusom
    @RestResource(path = "search3", rel = "search3")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndRecordStatusAndProjectStatusIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus") Integer recordStatus,
            @Param("projectStatusId") Long projectStatusId);

    //Sa RecordStatus-om, ProjectStatusom i ProjectType-om
    @RestResource(path = "search4", rel = "search4")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndRecordStatusAndProjectStatusIdAndProjectTypeIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus") Integer recordStatus,
            @Param("projectStatusId") Long projectStatusId,
            @Param("projectTypeId") Long projectTypeId);

    //Sa RecordStatus-om i ProjectType-om
    @RestResource(path = "search5", rel = "search5")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndRecordStatusAndProjectTypeIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("recordStatus") Integer recordStatus,
            @Param("projectTypeId") Long projectTypeId);

    //Sa ProjectStatus-om i ProjectType-om
    @RestResource(path = "search6", rel = "search5")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndProjectStatusIdAndProjectTypeIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("projectStatusId") Long projectStatusId,
            @Param("projectTypeId") Long projectTypeId);

    //Sa ProjectStatus-om
    @RestResource(path = "search7", rel = "search2")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndProjectStatusIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("projectStatusId") Long projectStatusId);

    //Sa ProjectType-om
    @RestResource(path = "search8", rel = "search2")
    List<Project> findByTitleSrbContainingAndTitleEngContainingAndTitleOthContainingAndAbstractSrbContainingAndAbstractEngContainingAndAbstractOthContainingAndKeywordsSrbContainingAndKeywordsEngContainingAndKeywordsOthContainingAndAcronymContainingAndUriContainingAndDspaceRecordIDContainingAndScopusIDContainingAndEcrisIDContainingAndCobissIDContainingAndMntrnContainingAndNoteContainingAndCreatorContainingAndModifierContainingAndProjectTypeIdAllIgnoreCase(
            @Param("titleSrb") String titleSrb,
            @Param("titleEng") String titleEng,
            @Param("titleOth") String titleOth,
            @Param("abstractSrb") String abstractSrb,
            @Param("abstractEng") String abstractEng,
            @Param("abstractOth") String abstractOth,
            @Param("keywordsSrb") String keywordsSrb,
            @Param("keywordsEng") String keywordsEng,
            @Param("keywordsOth") String keywordsOth,
            @Param("acronym") String acronym,
            @Param("uri") String uri,
            @Param("dspaceRecordID") String dspaceRecordID,
            @Param("scopusID") String scopusID,
            @Param("ecrisID") String ecrisID,
            @Param("cobissID") String cobissID,
            @Param("mntrn") String mntrn,
            @Param("note") String note,
            @Param("creator") String creator,
            @Param("modifier") String modifier,
            @Param("projectTypeId") Long projectTypeId);
}