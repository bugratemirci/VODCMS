package com.projects.vodcms.Entities;

import java.util.ArrayList;
import java.util.Collection;
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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name = "contents")
@Table(name = "contents")
@AllArgsConstructor
@NoArgsConstructor

public class Content {

	@Id
	@Column(name = "content_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "content_name")
	private String contentName;

	@Column(name = "content_status")
	private String contentStatus;

	@Column(name = "content_poster_url")
	private String contentPosterUrl;

	@Column(name = "content_video_url")
	private String contentVideoUrl;

	@JsonIgnore
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "contents_licences", joinColumns = { @JoinColumn(name = "content_id") }, inverseJoinColumns = {
			@JoinColumn(name = "licence_id") })
	private List<Licence> licences = new ArrayList<>();

	public List<Licence> getLicences() {
		return this.licences;
	}

	public void setLicences(List<Licence> licences) {
		this.licences = licences;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getContentStatus() {
		return contentStatus;
	}

	public void setContentStatus(String contentStatus) {
		this.contentStatus = contentStatus;
	}

	public String getContentPosterUrl() {
		return contentPosterUrl;
	}

	public void setContentPosterUrl(String contentPosterUrl) {
		this.contentPosterUrl = contentPosterUrl;
	}

	public String getContentVideoUrl() {
		return contentVideoUrl;
	}

	public void setContentVideoUrl(String contentVideoUrl) {
		this.contentVideoUrl = contentVideoUrl;
	}

}
