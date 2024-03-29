package com.projects.vodcms.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

import lombok.*;

@Data
@Entity(name = "contents")
@Table(name = "contents")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Content {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String contentName;

    private String contentStatus;

    private String contentPosterUrl;

    private String contentVideoUrl;

    private String contentDescription;

    @JsonIgnore
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "contents_licences", joinColumns = {@JoinColumn(name = "content_id")}, inverseJoinColumns = {
            @JoinColumn(name = "licence_id")})
    private List<Licence> licences = new ArrayList<>();


}
