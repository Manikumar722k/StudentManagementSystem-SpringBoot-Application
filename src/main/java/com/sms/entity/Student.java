package com.sms.entity;

import java.io.FileInputStream;
import java.sql.Blob;
import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Please Mention Student Name")
	private String stu_name;
	
	@NotBlank(message = "Please Mention Student Mail")
	private String stu_email;
	
	@NotBlank(message = "Please Mention Student Gender")
	private String stu_gender;
	
	@NotNull(message = "Please Mention Student DOB")
	private LocalDate stu_dob;
	
	@NotNull(message = "Please Mention Student ID")
	private Long stu_id;
	
	@NotBlank(message = "Please Mention Student Father Name")
	private String stu_father_name;
	
	@NotBlank(message = "Please Mention Student Mother Name")
	private String stu_mother_name;
	
	@NotNull(message = "Please Mention Student Contact Number")
	private Long stu_contact_number;
	
	private Long stu_alternate_contact_number;
	
	@NotBlank(message = "Please Mention Student Address")
	private String stu_address;
	
}
