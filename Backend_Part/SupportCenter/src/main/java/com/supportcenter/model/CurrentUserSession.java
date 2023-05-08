package com.supportcenter.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CurrentUserSession {

	
	@Id
	@Column(unique = true)
	private int Id;
	
	private String uuid;
	
	private LocalDateTime timestamp;
	
//	private String User_Type;
	
}
