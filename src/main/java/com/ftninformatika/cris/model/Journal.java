package com.ftninformatika.cris.model;

import lombok.*;
import org.hibernate.annotations.CollectionId;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Set;

@RepositoryEventHandler
@ToString(of = {"id", "nameSrb"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "journal")
public class Journal {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   @Column(length = 500)
   private String nameSrb;

   @Column(length = 500)
   private String nameEng;

   @Column(length = 500)
   private String nameOth;

   @Column(unique = true)
   private String pissn;

   @Column(unique = true)
   private String eissn;

   private String abbreviationSrb;

   private String abbreviationEng;

   private String abbreviationOth;

   @Column(length = 4500)
   private String abstractSrb;

   @Column(length = 4500)
   private String abstractEng;

   @Column(length = 4500)
   private String abstractOth;

   private String note;

   private String uri;

   private String scopusID;

   private String cobissID;

   private String ecrisID;

   private String creator;

   private String modifier;

   private LocalDateTime creationDate;

   private LocalDateTime lastModificationDate;

   private Integer recordStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="journalStatus_id", referencedColumnName="id", nullable=true)
   private JournalStatus journalStatus;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="language_id", referencedColumnName="id", nullable=true)
   public Language language;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="publisher_id", referencedColumnName="id", nullable=true)
   public Publisher publisher;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="journal")
   public Set<JournalEditors> journalEditors;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="journal")
   public Set<PaperJournal> paperJournal;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="journal")
   public Set<JournalGuestEditors> journalGuestEditors;

}