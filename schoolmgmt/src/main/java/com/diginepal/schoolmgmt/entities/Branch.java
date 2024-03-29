package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity 
@Table(name="branch")
@Data
@EqualsAndHashCode(callSuper = false)
public class Branch extends BaseEntity{
private int code;
private String name;
private String address;
private String phone;
private String email;

@ManyToOne
@JoinColumn(name = "company_id")
private Company company;

}
