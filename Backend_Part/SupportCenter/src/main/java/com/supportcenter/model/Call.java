package com.supportcenter.model;

import java.time.LocalDate;

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
public class Call {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer callId;
	
	
	@NotNull(message = "Mandatory field")
	private String problemDescription;
	
	@NotNull(message = "Mandatory field")
	private LocalDate callDate;
	
	@NotNull(message = "Mandatory field")
	@Pattern(regexp = "^[0-9]{10}$", message = "Invalid mobile number")
	private String phoneNumber;
}
