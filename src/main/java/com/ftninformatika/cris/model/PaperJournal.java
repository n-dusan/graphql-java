package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb", "subtitleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paperJournal")
public class PaperJournal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 500)
    private String titleSrb;

    @Column(length = 500)
    private String titleEng;

    @Column(length = 500)
    private String titleOth;

    private String subtitleSrb;

    private String subtitleEng;

    private String subtitleOth;

    private String startPage;

    private String endPage;

    private String volume;

    private String number;

    private String note;

    @Column(length = 800)
    private String keywords;

    @Column(length = 800)
    private String keywordsEng;

    @Column(length = 800)
    private String keywordsOth;

    @Column(length = 4500)
    private String apstract;

    @Column(length = 4500)
    private String abstractEng;

    @Column(length = 4500)
    private String abstractOth;

    private String uri;

    private String doi;

    @Column(unique = true)
    private String scopusID;

    @Column(unique = true)
    private String cobissID;

    private String year;

    @Column(unique = true)
    private String dspaceRecordID;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="paperJournalType_id", referencedColumnName="id", nullable=true)
    public PaperJournalType paperJournalType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="paperJournalStatus_id", referencedColumnName="id", nullable=true)
    public PaperJournalStatus paperJournalStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="journal_id", referencedColumnName="id", nullable=true)
    public Journal journal;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
    public Language language;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperJournal")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy = "paperJournal")
    public Set<Acknowledgement> acknowledgement;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="paperJournal")
    public Set<PaperJournalAuthors> paperJournalAuthors;

    /*Koristimo samo prilikom prenosa podataka iz ScopusDocumentUtility u kontroler gde
    * imamo pristup repository-ima. Transit je posto nam ne treba mapiranje u bazi.
    * Ovo radimo zato sto prvo moramo snimiti journal pa tek onda mozemo snimati
    * PaperJournalAuthors*/
    @Transient
    public ArrayList<PaperJournalAuthors> paperJournalAuthorsTemporary;

}