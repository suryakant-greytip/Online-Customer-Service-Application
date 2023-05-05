package com.supportcenter.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
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
}
