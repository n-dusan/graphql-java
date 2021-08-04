package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;

@ToString(of = {"id", "name", "email"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "userAccount")
public class UserAccount {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;

   private String name;

   private String email;

   private String userpassword;

   private String note;

   private String activationCode;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="institution_id", referencedColumnName="id", nullable=false)
   public Institution institution;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="userGroup_id", referencedColumnName="id", nullable=false)
   public UserGroup userGroup;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="language_id", referencedColumnName="id", nullable=false)
   public Language language;

   @ManyToOne(fetch=FetchType.LAZY)
   @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
   public Person person;
   
}