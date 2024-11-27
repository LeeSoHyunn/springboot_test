package com.mysite.sbb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerService;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionService;

import lombok.RequiredArgsConstructor;
@Controller
@RequiredArgsConstructor
public class AnswerController {
	
	private final QuestionService questionService;
	private final AnswerService answerService;
	
	@PostMapping("/answer/create/{id}")
	public String createAnswer(Model model, 
			@PathVariable("id") Integer id,
			@RequestParam("content") String content) {
		Question question= this.questionService.getQuestion(id);
		//답변에 코드추가
		this.answerService.create(question, content);		
		return String.format("redirect:/question/detail/%s", id);
	}
}
