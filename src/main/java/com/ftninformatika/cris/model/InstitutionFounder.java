package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@ToString(of = {"id", "institution", "founder"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institutionFounder")
public class InstitutionFounder {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String rescriptNumber;

   private LocalDate date;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="founder_id", referencedColumnName="id", nullable=false)
   public Founder founder;

}