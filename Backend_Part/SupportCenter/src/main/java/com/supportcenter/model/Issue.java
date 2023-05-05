package com.supportcenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
public class Issue {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer issueId;
	
	@NotNull(message = "Mandatory field")
	private String issueType;
	
	
	@NotNull(message = "Mandatory field")
	private String description;
	
	
	@NotNull(message = "Mandatory field")
	private IssueStatus status;
}
