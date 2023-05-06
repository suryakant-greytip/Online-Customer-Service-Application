package com.supportcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Repository
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer operatorId;
	
	@NotNull(message = "Mandatory field")
	 private String firstName;
	
	 private String  lastName;
	 
	 @Email(message = "Mandatory field")
	 private String  email;
	 
	 @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	 private String  mobile;
	 
	 
	 @NotNull
	 (message = "Mandatory field")
	 private String city;


	@JsonIgnore
	@OneToMany(mappedBy = "operator")
	private List<Call> calls = new ArrayList<>();


	@JsonIgnore
	@OneToMany(mappedBy = "operator")
	private List<Solution> solutions = new ArrayList<>();


	@ManyToOne
	@JoinColumn(name = "departmentId")
	@Valid
	private Department department;
	
	
}
