package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="housegroup")
@Data
@EqualsAndHashCode(callSuper= false)
public class Housegroup extends BaseEntity {
	
	@Column(name="house_group", nullable= true)
	private String houseGroup;

}
