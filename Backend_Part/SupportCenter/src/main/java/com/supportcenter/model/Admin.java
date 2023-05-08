package com.supportcenter.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
public class Admin {
	
		
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int adminId;
		
		
		@NotBlank(message="admin name should not be blank!")
		@NotEmpty(message="admin name should not be empty!")
		@NotNull(message="Admin name should not null!")
		private String adminName;
		
		@Column(unique = true)
		private String email;
		
		@Size(min=4, max=8, message="Password length should be between  4 and 8")
		private String password;

		
		
	}

