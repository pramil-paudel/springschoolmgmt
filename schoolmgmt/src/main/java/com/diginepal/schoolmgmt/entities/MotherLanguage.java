package com.diginepal.schoolmgmt.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="motherlanguage")
@Data
@EqualsAndHashCode(callSuper= false)
public class MotherLanguage extends BaseEntity {
	
	@Column(name="mother_language")
	private String motherLanguage;
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy= "motherLanguage")
	private Student student;
}
