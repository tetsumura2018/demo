package com.example.demo.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.demo.dto.LoginForm;
import com.example.demo.service.LoginService;

@Controller
public class LoginController {

	@Autowired
    LoginService loginService;

    @GetMapping(value={"/login"})
    public String getLogin(@ModelAttribute("LoginForm")LoginForm form, Model model) {
    	model.addAttribute("title", "ログイン"); 
    	return "login";
//    	return "redirect:/user/list";
    }
}