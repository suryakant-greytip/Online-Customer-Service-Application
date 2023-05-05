package com.supportcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

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


	@JsonIgnore
	@OneToMany(mappedBy = "department", fetch = FetchType.EAGER)
	private List<Operator> operators = new ArrayList<>();
}
