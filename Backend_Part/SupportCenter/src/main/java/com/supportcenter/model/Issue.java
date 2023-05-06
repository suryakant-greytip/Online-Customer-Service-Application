package com.supportcenter.model;

import org.springframework.stereotype.Repository;

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
@Repository
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
