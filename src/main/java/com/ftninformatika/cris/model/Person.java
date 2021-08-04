package com.ftninformatika.cris.model;

import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    private String middleName;

    private LocalDate dateOfBirth;

    private String placeOfBirth;

    private String state;

    private String address;

    private String city;

    private String bibliographySrb;

    private String bibliographyEng;

    private String bibliographyOth;

    private String keywordsSrb;

    private String keywordsEng;

    private String keywordsOth;

    private String gender;

    private String uri;

    private String email;

    private String orcid;

    private String scopusID;

    private String cobissID;

    private String ecrisID;

    private String dspaceRecordID;

    private String jmbg;

    private String phones;

    private String researchAreas;

    private String mntrn;

    private String note;

    private String creator;

    private String modifier;

    private LocalDateTime creationDate;

    private LocalDateTime lastModificationDate;

    private Integer recordStatus;

    private Boolean alreadyRegistered;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
    private Language language;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="personType_id", referencedColumnName="id", nullable=true)
    public PersonType personType;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    private Set<PersonName> otherName;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    private Set<TitleInstitution> titleInstitution;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    private Set<UserAccount> user;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PersonCategory> category;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PersonInstitution> institution;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<JournalEditors> journalEditors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PaperJournalAuthors> paperJournalAuthors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<ProceedingsEditors> proceedingsEditors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PaperProceedingsAuthors> paperProceedingsAuthors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<MonographEditors> monographOfPapersMonographEditors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PaperMonographAuthors> paperMonographAuthors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<Thesis> these;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<PatentAuthors> authors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<ProductAuthors> productAuthors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<MonographAuthors> monographAuthors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<JournalGuestEditors> journalGuestEditors;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<File> file;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<Advisor> advisor;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<Commission> commission;

    @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="person")
    public Set<Participant> participant;

}