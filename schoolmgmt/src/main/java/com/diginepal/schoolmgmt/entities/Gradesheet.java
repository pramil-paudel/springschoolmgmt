package com.diginepal.schoolmgmt.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table
public class Gradesheet extends BaseEntity{
private Double low;
private Double high;
private String grade;
public Double getLow() {
	return low;
}
public void setLow(Double low) {
	this.low = low;
}
public Double getHigh() {
	return high;
}
public void setHigh(Double high) {
	this.high = high;
}
public String getGrade() {
	return grade;
}
public void setGrade(String grade) {
	this.grade = grade;
}

}
