package com.supportcenter.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Login {

	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@Enumerated(EnumType.STRING)
	UserType type;
	
	private boolean isActive;
		
}
