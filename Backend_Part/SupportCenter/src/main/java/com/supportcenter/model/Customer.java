package com.supportcenter.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;
	
	@NotBlank(message = "First Name cannot be Blank")
	@NotEmpty(message = "First Name cannot be Empty")
	@NotNull(message = "First Name cannot be Null")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be Blank")
	@NotEmpty(message = "Last Name cannot be Empty")
	@NotNull(message = "Last Name cannot be Null")
	private String lastName ;
	
	@Column(unique = true)
	@Email
	private String email;
	
	@Column(unique = true)
	private String mobile;
	@NotBlank(message = "Password cannot be Blank")
	@NotEmpty(message = "Password cannot be Empty")
	@NotNull(message = "Password cannot be Null")
	private String password;
	
	private String city;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Issue> issue = new ArrayList<>();
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "customer")
	private List<Call> call = new ArrayList<>();

	 
	 
}
