package com.hipradeep.blog.payloads;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {

	private int id;
	@NotEmpty
	@Size(min = 4, message = "Username must have min 4 dharacters")
	private String name;

	@Email(message = "Youre email is not valid")
	private String email;
	
	@NotEmpty
	@Size(min = 3,max=10,  message = "password must be od min and max 10 characters")
	private String password;
	
	@NotEmpty
	private String about;
}