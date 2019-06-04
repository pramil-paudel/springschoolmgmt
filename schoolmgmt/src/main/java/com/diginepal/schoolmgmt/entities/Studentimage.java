package com.diginepal.schoolmgmt.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
@Entity
@Table(name="studentimage")
public class Studentimage {
	
	@Lob
	@Column(nullable=true)
	@Basic(fetch=FetchType.LAZY)
	private byte[] image;

}
