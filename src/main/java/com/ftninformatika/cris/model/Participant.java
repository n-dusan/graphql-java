package com.ftninformatika.cris.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@ToString(of = {"id", "firstName", "middleName", "lastName"})
@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer numOrder;

    private String firstName;

    private String lastName;

    private String middleName;

    private String email;

    private String affiliations;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="person_id", referencedColumnName="id", nullable=false)
    public Person person;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="project_id", referencedColumnName="id", nullable=false)
    public Project project;

    @OneToMany(mappedBy="participant")
    public Set<ParticipantRole> role;



}