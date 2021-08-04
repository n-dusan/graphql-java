package com.ftninformatika.cris.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "journalEditors")
public class JournalEditors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String startYear;

   private String startVolume;

   private String startNumber;

   private String endYear;

   private String endVolume;

   private String endNumber;

   private Integer numberOfEditors;

   private String firstName;

   private String lastName;

   private String middleName;

   private String email;

   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="journal_id", referencedColumnName="id", nullable=false)
   public Journal journal;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

}