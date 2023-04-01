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
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Licence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String licenceName;

    private Date startTime;

    private Date endTime;

    @JsonIgnore
    @ManyToMany(mappedBy = "licences")

    private Collection<Content> contents = new ArrayList<>();

}
