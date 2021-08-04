package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "titleSrb", "subtitleSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "thesis")
public class Thesis {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titleSrb;

    private String titleEng;

    private String titleOth;

    private String subtitleSrb;

    private String subtitleEng;

    private String subtitleOth;

    private String abstractSrb;

    private String abstractEng;

    private String abstractOth;

    private String keywordsSrb;

    private String keywordsEng;

    private String keywordsOth;

    private String studyType;

    private String uri;

    private String dspaceRecordID;

    private String year;

    private Integer numberOfPages;

    private String scopusID;

    private String ecrisID;

    private String cobissID;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
    public Institution institution;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="commission_id", referencedColumnName="id", nullable=false)
    public Commission commission;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
    public Language language;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
    public Person person;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="publisher_id", referencedColumnName="id", nullable=false)
    public Publisher publisher;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="thesisStatus_id", referencedColumnName="id", nullable=false)
    public ThesisStatus thesisStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="thesisType_id", referencedColumnName="id", nullable=false)
    public ThesisType thesisType;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="thesis")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="thesis")
    public Set<Advisor> advisor;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="thesis")
    public Set<Acknowledgement> acknowledgement;

}