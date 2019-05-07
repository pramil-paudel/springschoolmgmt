package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "section")
@Data
@EqualsAndHashCode(callSuper = false)
public class Section extends BaseEntity {
	@Column(nullable = false)
	private String name;
}
