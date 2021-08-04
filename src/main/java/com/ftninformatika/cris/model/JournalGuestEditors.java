package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "journalGuestEditors")
public class JournalGuestEditors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String year;

   private String volume;

   private String number;

   private Integer numberOfGuestEditors;

   private String firstName;

   private String lastName;

   private String middleName;

   private String email;

   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="journal_id", referencedColumnName="id", nullable=false)
   private Journal journal;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

}