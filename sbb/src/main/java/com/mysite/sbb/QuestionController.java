package com.mysite.sbb;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mysite.sbb.answer.AnswerForm;
import com.mysite.sbb.question.Question;
import com.mysite.sbb.question.QuestionForm;
import com.mysite.sbb.question.QuestionRepository;
import com.mysite.sbb.question.QuestionService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class QuestionController {
	
	private final QuestionService questionService;
	
	
	//목록보기
	@GetMapping("/question/list")
	public String list(Model model) {
		List<Question> questionList = this.questionService.getList();
		model.addAttribute("questionList", questionList);
		return "question_list";
	}
	
	//상세보기
	@GetMapping("/question/detail/{id}")
	public String detail(Model model, @PathVariable("id") Integer id
			, AnswerForm answerForm) {
		Question question = this.questionService.getQuestion(id); //서비스연결해서 DB데이터 값 가져오기
		model.addAttribute("question", question);
		return "question_detail";
	}
	
	// 질문 등록
	@GetMapping("/question/create")
	public String questionCreate(QuestionForm questionForm) {
		return "question_form";
	}
	
//	@PostMapping("/question/create")
//	public String questionCreate(@RequestParam(value="subject") String subject, 
//			@RequestParam(value="content") String content) {
//		
//		this.questionService.create(subject, content);
//		return "redirect:/question/list";
//	}
	
	@PostMapping("/question/create")
	public String questionCreate(@Valid QuestionForm questionForm,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "question_form";
		}
		
		this.questionService.create(questionForm.getSubject(),
				questionForm.getContent());
		return "redirect:/question/list";
	}

}
