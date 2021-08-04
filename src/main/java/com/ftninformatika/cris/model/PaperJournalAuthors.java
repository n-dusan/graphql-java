package com.ftninformatika.cris.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.awt.datatransfer.FlavorEvent;

@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "paperJournalAuthors")
public class PaperJournalAuthors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer numOrder;

   @Column(length = 500)
   private String firstName;

   @Column(length = 500)
   private String lastName;

   private String middleName;

   private String email;

   @Column(length = 500)
   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "paper_journal_id", referencedColumnName = "id", nullable = false)
   public PaperJournal paperJournal;

}