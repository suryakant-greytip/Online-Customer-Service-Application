package com.supportcenter.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Solution {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull(message = "Mandatory field")
	private Integer solutionId;
	
	@NotNull(message = "Mandatory field")
	private String solutionDescription;
	
	@NotNull(message = "Mandatory field")
	private LocalDate solutionDate;
}
