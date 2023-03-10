package com.gyojincompany.home.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gyojincompany.home.command.BCommand;
import com.gyojincompany.home.command.BContentCommand;
import com.gyojincompany.home.command.BDeleteCommand;
import com.gyojincompany.home.command.BListCommand;
import com.gyojincompany.home.command.BModifyCommand;
import com.gyojincompany.home.command.BReplyCommand;
import com.gyojincompany.home.command.BWriteCommand;

@Controller
public class BController {
	
	BCommand command = null;
	
	@RequestMapping(value = "/")
	public String index() {
		
		return "index";
	}
	
	@RequestMapping(value = "/list")
	public String list(Model model) {
		
		command = new BListCommand();
		command.excute(model);
		
		return "list";
	}
	
	@RequestMapping(value = "/writeForm")
	public String writeForm() {
		
		return "write_form";
	}
	
	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BWriteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/contentView")
	public String contentView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		return "content_view";
	}
	
	@RequestMapping(value = "/modifyView")
	public String modifyView(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		return "content_modify";
	}
	
	@RequestMapping(value = "/modify", method = RequestMethod.POST)
	public String modify(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BModifyCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/delete")
	public String delete(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BDeleteCommand();
		command.excute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping(value = "/replyWrite")
	public String replyWrite(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BContentCommand();
		command.excute(model);
		
		return "reply_write";
	}
	
	@RequestMapping(value = "/reply")
	public String reply(HttpServletRequest request, Model model) {
		
		model.addAttribute("request", request);
		
		command = new BReplyCommand();
		command.excute(model);
		
		return "redirect:list";
	}

}
