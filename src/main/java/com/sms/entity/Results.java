package com.sms.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Results {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	private Long id;
	
	private Long regNumber;
	
	private Integer discreteMathematicalStructures;
	private String discreteMathematicalStructuresGrade;
	
	private Integer managementAccountancy;
	private String managementAccountancyGrade;
	
	private Integer cProgrammingDataStructures;
	private String cProgrammingDataStructuresGrade;
	
	private Integer computerOrganization;
	private String computerOrganizationGrade;
	
	private Integer operatingSystems;
	private String operatingSystemsGrade;
	
	private Integer designAnalysisOfAlgorithm;
	private String designAnalysisOfAlgorithmGrade;
	
	private Integer cProgrammingDataStructuresLab;
	private String cProgrammingDataStructuresLabGrade;
	
	private Integer operatingSystemsAndComputerOrganization;
	private String operatingSystemsAndComputerOrganizationGrade;
	
	private Integer moocs;
	private String moocsGrade;
}
