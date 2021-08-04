package com.ftninformatika.cris.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "personInstitution")
public class PersonInstitution {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate startDate;

   private LocalDate endDate;

   private String description;

   private String researchArea;

   private Integer percentage = 100;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="personInstitutionPosition_id", referencedColumnName="id", nullable=true)
   public PersonInstitutionPosition personInstitutionPosition;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   private Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="personInstitutionFunction_id", referencedColumnName="id", nullable=true)
   public PersonInstitutionFunction personInstitutionFunction;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="personInstitutionStatus_id", referencedColumnName="id", nullable=true)
   public PersonInstitutionStatus personInstitutionStatus;

}