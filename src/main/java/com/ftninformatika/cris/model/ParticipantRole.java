package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;

@ToString(of = {"id", "name", "description"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participantRole")
public class ParticipantRole {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String description;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="participant_id", referencedColumnName="id", nullable=false)
   public Participant participant;

}