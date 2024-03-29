package com.diginepal.schoolmgmt.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "differentlyable")
@Data
@EqualsAndHashCode(callSuper = false)
public class DifferentlyAbleType extends BaseEntity {

	@Column(name = "name", nullable = true)
	private String name;

}
