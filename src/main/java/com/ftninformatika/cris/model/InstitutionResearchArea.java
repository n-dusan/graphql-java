package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString(of = {"id", "institution", "researchArea"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institutionResearchArea")
public class InstitutionResearchArea {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String note;

   @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
   @JoinColumn(name="researchArea_id", referencedColumnName="id", nullable=false)
   public ResearchArea researchArea;

   @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.REMOVE)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

}