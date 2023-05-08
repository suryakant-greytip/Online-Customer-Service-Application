package com.supportcenter.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Repository
public class Operator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer operatorId;
	
	@NotBlank(message = "First Name cannot be Blank")
	@NotEmpty(message = "First Name cannot be Empty")
	@NotNull(message = "First Name cannot be Null")
	private String firstName;
	
	@NotBlank(message = "Last Name cannot be Blank")
	@NotEmpty(message = "Last Name cannot be Empty")
	@NotNull(message = "Last Name cannot be Null")
	private String lastName;
	
	@Email
	@Column(unique = true)
	private String email;
	
	private String password;
	
	@Column(unique = true)
	private String mobile;
	
	private String city;
	
	
	@OneToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL, mappedBy = "operator")
	private List<Call> call=new ArrayList<>();
	
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="dept_id")
	private Department department;

	
}
