package com.projects.vodcms.Entities;

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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "licences")
@Table(name = "licences")
@AllArgsConstructor
@NoArgsConstructor
public class Licence {
    @Id
    @Column(name = "licence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "licence_name")
    private String licenceName;

    @Column(name = "licence_start_time")
    private Date startTime;

    @Column(name = "licence_end_time")
    private Date endTime;
    
    @JsonIgnore
    @ManyToMany(mappedBy = "licences")

    private Collection<Content> contents = new ArrayList<>();

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLicenceName() {
        return this.licenceName;
    }

    public void setLicenceName(String licenceName) {
        this.licenceName = licenceName;
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

}
