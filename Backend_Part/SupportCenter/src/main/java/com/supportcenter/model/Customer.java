package com.supportcenter.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder.Default;
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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
	@NotNull(message = "Mandatory field")
	 private String firstName;
	
	 private String  lastName;
	 
	 @Email(message = "Mandatory field")
	 private String  email;

	@NotNull(message = "Mandatory field")
	@Size(min = 6, max = 10 , message = "Character should be between 6 to 10")
	private String password;
	 
	 @Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	 private String  mobile;
	 
	 
	 @NotNull
	 (message = "Mandatory field")
	 private String city;

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Call> calls = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "customer")
	private List<Issue> issues = new ArrayList<>();
	
	@Default()
	private boolean isActive ;
	
	@JsonIgnore
	private List<Integer> operatorIdList;
}
