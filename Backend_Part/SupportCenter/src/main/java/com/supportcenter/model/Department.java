package com.supportcenter.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Department {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer departmentId;
	
	
	@NotNull(message = "Mandatory field")
	private String  departmentName;
	
	
	@OneToMany(mappedBy="department")
	private List<Operator> operatorList;
	
}
