package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

//@Document(indexName = "institution", type = "Institution")
@RepositoryEventHandler
@ToString(of = {"id", "nameSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institution")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameSrb;

    private String nameEng;

    private String nameOth;

    private String address;

    private String place;

    private String postalCode;

    private String acro;

    private String keywordsSrb;

    private String keywordsEng;

    private String keywordsOth;

    private String uri;

    private String email;

    private String phone;

    private String pib;

    private String maticniBroj;

    private String bankAccount;

    private String ecrisID;

    private String nioID;

    private String mntrID;

    private String orcid;

    private String scopusID;

    private String dspaceRecordID;

    private String note;

    private String accreditationNumber;

    private LocalDate accreditationDate;

    private String accreditationNote;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
    public Language language;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institutionStatus_id", referencedColumnName="id", nullable=true)
    public InstitutionStatus institutionStatus;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="institutionType_id", referencedColumnName="id", nullable=true)
    public InstitutionType institutionType;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="superInstitution_id", referencedColumnName="id", nullable=true)
    private Institution superInstitution;

    @OneToMany(mappedBy="superInstitution")
    private Set<Institution> subInstitutions;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    private Set<TitleInstitution> titleInstitution;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    private Set<UserAccount> user;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<PersonInstitution> person;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<InstitutionFounder> founder;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<InstitutionResearchArea> researchArea;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<InstitutionActivity> activity;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<Thesis> these;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="institution")
    public Set<Partner> partner;

}