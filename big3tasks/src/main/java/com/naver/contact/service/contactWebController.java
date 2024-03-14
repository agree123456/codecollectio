package com.naver.contact.service;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.naver.contact.contactDao.contactdao;
import com.naver.contact.dto.Contact;

@Controller
@RequestMapping("/contact")
public class contactWebController {
	@Autowired
 	contactdao dao;
 	
	public contactWebController(contactdao dao) {
		this.dao = dao;
	}//생성자에 넣는게 좋다
	@GetMapping("/login")
	public String login(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR","페이지 이동 에러");
		}
		return "contact/login"; //선택한 뉴스를 forwarding처리해서 보여줘라 
	}
	@GetMapping("/signup")
	public String signup(Model model) {
		try {
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("ERROR","페이지 이동 에러");
		}
		return "contact/signup"; //선택한 뉴스를 forwarding처리해서 보여줘라 
	}
	
	
	
	
	@PostMapping("/add")
	public String addcontact(@ModelAttribute Contact dto, Model model){
		try {
			dao.ContactInsert(dto);
			//여기까지 되면 정상처리됨
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","추가에러");
		} 
		return "redirect:/contact/list";//다시 요청url
	}
	@GetMapping("/list")	
	public String Select(@ModelAttribute Contact dto, Model model) {
		ArrayList<Contact> list;
		try {
			list = dao.select();
			model.addAttribute("list",list);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "연락처목록에러");
		}
		return "contact/main";
	}
	
	//
	@GetMapping("/delete/{member_id}")
	public String deleteNews(@PathVariable int member_id, Model model) {
		try {
			dao.Delect(member_id);
			
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "연락처삭제이슈");
			
		}
		return "redirect:/contact/list";
	}
	//뉴스삭제 완료 크으
	@GetMapping("/update/{member_id}")
	public String getone(@PathVariable int member_id, Model model) {
		
		try {
			Contact list = dao.updateone(member_id);
			model.addAttribute("list", list);
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error", "뉴스 상세에러");
		}
		return "/contact/Update";
	}
	@PostMapping("/updatess/{member_id}")
	public  String updatecontact(@PathVariable int member_id, @ModelAttribute Contact dto, Model model)
	{
		try {
			
			dao.updatetwo(dto);
			
			//여기까지 되면 정상처리됨
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("error","수정에러");
		} 
		return "redirect:/contact/list";//다시 요청url
	}
}
