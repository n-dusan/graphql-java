package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(of = {"id", "numOrder"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partner")
public class Partner {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private Integer numOrder;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="project_id", referencedColumnName="id", nullable=false)
   public Project project;

   @OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="partner")
   public Set<PartnerRole> role;

}