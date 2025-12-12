package com.example.demo.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginForm;

@Service
public class LoginService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	  
    private final BCryptPasswordEncoder passwordEncoder;
    
    public LoginService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder; 	
    }
    
	public LoginForm clear(LoginForm form) {
		form.setUsername("");
		return form;
	}
	
	public LoginForm select(String username) {
		String query = "SELECT * FROM login WHERE username = '" + username + "'";
		List<Map<String, Object>> tmp = jdbcTemplate.queryForList(query);
		LoginForm form = new LoginForm();
		
		if (tmp.size() != 0) {
			form.setLoginid((int)tmp.get(0).get("loginid")); 
			form.setUsername((String) tmp.get(0).get("username")); 
			form.setPassword((String) tmp.get(0).get("password")); 
			form.setFullname((String) tmp.get(0).get("fullname")); 			
		}
		return form;		
	}
}