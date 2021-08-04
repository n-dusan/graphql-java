package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;

@ToString(of = {"id", "name", "description"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "partnerRole")
public class PartnerRole {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String description;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="partner_id", referencedColumnName="id", nullable=false)
   public Partner partner;

}