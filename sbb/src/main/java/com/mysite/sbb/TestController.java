package com.mysite.sbb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.mysite.sbb.etc.DataDto;
import com.mysite.sbb.etc.User1;

@Controller
public class TestController {
	//자바에서(컨트롤러)에서 뷰에 전달하는법 : Model, ModelAndView
	
	@GetMapping("/test/textbasic")
	public String textBasic(Model model) {
		
		model.addAttribute("data", "Hello <b><i> Spring!</i></b>");
		return "text_basic"; //templates폴더에 text_basic.html 
	}
	
	//하이퍼링크 값 전달 
	@GetMapping("/test/link")
	public String link(Model model) {
		model.addAttribute("param1", "아무거나");
		model.addAttribute("param2", "data2");
		return "link";
	}
	
	//객체 생성->전달
	@GetMapping("/test/variable")
	public String variable(Model model) {
		User1 userA = new User1("홍길동", 10);
		User1 userB = new User1("자기이름", 22);
		
		model.addAttribute("user", userA);
		
		//list 
		List<User1> list = new ArrayList<>();
		list.add(userA);
		list.add(userB);
		
		model.addAttribute("users", list);
		
		Map<String, User1> map = new HashMap<>();
		map.put("userA", userA);
		map.put("userB", userB);
		map.put("userA1", userA);
		
		model.addAttribute("usermap", map);
		
		return "variable";
	}
	
	//if 문
	@GetMapping("/test/ifEx")
	public String ifEx(Model model) {
		model.addAttribute("data","이문자열이 보임");
		return "ifEx";
	}
	
	//반복문 : each
	@GetMapping("/test/forEx")
	public String forEx(Model model) {
		List<DataDto> d_list = new ArrayList<>();
		for(int i=0; i<5; i++) {
			DataDto data = new DataDto();
			data.setName("이름 " + i);
			data.setAge(25 + i);
			data.setAddress("주소 " + i);
			d_list.add(data);
		}
		model.addAttribute("dList", d_list);
		return "forEx";
	}
	
	
	
	
}

