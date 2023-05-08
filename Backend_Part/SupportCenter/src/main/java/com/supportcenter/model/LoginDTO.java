package com.supportcenter.model;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
public class LoginDTO {

	private String mobileNo;
	private String password;
	//private String role;
	
}