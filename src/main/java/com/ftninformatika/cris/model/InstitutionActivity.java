package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString(of = {"id", "note", "institution", "activity"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "institutionActivity")
public class InstitutionActivity {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String note;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="activity_id", referencedColumnName="id", nullable=false)
   public Activity activity;

}