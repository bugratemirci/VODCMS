package com.projects.vodcms.entities;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Data
@Entity(name = "licences")
@Table(name = "licences")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Licence {
    @Id
    @Column(name = "licence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "licence_name")
    private String licenceName;

    @Column(name = "licence_start_time")
    private Date startTime;

    @Column(name = "licence_end_time")
    private Date endTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "licences")

    private Collection<Content> contents = new ArrayList<>();

}
