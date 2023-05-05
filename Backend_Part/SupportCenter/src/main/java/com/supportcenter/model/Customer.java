package com.supportcenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
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
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;
	
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
}
