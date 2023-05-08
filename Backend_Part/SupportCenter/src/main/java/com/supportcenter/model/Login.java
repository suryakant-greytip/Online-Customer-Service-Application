package com.supportcenter.model;

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

	@NotNull(message = "email cannot set as null")
	private String email;

	@NotNull(message = "password cannot set as null")
	private String password;

	
	private String User_Type;
}
