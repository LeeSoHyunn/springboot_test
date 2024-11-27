package com.mysite.sbb.question;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
	
	@NotEmpty(message = "필수입력항목")
	@Size(max=200)
	private String subject;
	
	@NotEmpty(message = "필수입력항목")
	private String content;
}
