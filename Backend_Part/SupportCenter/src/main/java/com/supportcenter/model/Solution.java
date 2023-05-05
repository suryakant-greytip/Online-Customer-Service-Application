package com.supportcenter.model;

import java.time.LocalDate;

import jakarta.persistence.*;
import jakarta.validation.Valid;
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


	@OneToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
	@JoinColumn(name = "issueId")
	@Valid
	private Issue issue;


	@ManyToOne
	@JoinColumn(name = "operatorId")
	private Operator operator;
}
