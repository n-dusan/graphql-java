package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "proceedingsEditors")
public class ProceedingsEditors {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private LocalDate startDate;

   private LocalDate endDate;

   private String firstName;

   private String lastName;

   private String middleName;

   private String email;

   private String affiliations;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="proceedings_id", referencedColumnName="id", nullable=false)
   public Proceedings proceedings;

}