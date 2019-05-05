package com.diginepal.schoolmgmt.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "student")
@Data
@EqualsAndHashCode(callSuper = false)
public class Student extends BaseEntity {

	@Column(name = "legacy_id", unique = true, nullable = false)
	private String legacyId;

	@Column(name = "student_name", nullable = false)
	@NotBlank(message = "Student Name should not be blank")
	private String studentName;

	@Column(name = "Gender", nullable = false)
	private String gender;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob_nepali", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date dobNepali;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "dob_english", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date dobEnglish;

	@Column(name = "roll_no", unique = true, nullable = false)
	private String rollNo;

	@Column(name = "Old_School")
	private String oldSchool;

	@Lob
	@Column(name = "leaving_reason")
	private String reasonLeave;

	@Column(name = "Hobby", nullable = false)
	private String hobby;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "admission_nepali_date", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date admissionDatenp;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "admission_english_date", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date admissionDateen;

	@Column(name = "religion")
	private String religion;

	// Contact Details
	@Column(name = "district")
	private String district;

	@Column(name = "municipality")
	private String municipality;

	@Column(name = "ward_no")
	private int wardNo;

	@Column(name = "temporary_add")
	private String temporaryAddress;

	@Column(name = "student_image", nullable = true)
	private String studentImage;
	// Birth Certificate Details

	@Column(name = "birth_certificaten_no", unique = true)
	private String birthCertificate_no;

	@Column(name = "issued_by")
	private String issuedBy;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "issueddate_nepali", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date issuedDateNepali;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "issueddate_english", nullable = false)
	@NotNull(message = "Cannot be Empty")
	private Date issuedDateEnglish;

	@Column(name = "blood_grp")
	// @Pattern(regexp = "^(A|B|AB|O)[-+]$", message = "Invalid Blood Group")
	private String bloodGroup;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "father_id")
	private Father father;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "mother_id")
	private Mother mother;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "local_guardian_id")
	private LocalGuardian localGuardian;
	
	@OneToOne(fetch= FetchType.LAZY)
	@JoinColumn(name="mother_language_id")
	private MotherLanguage motherLanguage;
}
