package com.diginepal.schoolmgmt.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name="motherlanguage")
@Data
@EqualsAndHashCode(callSuper= false)
public class MotherLanguage extends BaseEntity {
	private String name;
}
