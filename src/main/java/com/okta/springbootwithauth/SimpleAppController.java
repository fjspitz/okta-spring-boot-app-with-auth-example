package com.okta.springbootwithauth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.okta.springbootwithauth.service.AdminService;

@Controller
class SimpleAppController {
    
	final AdminService adminService;
	
	@Autowired
	public SimpleAppController(AdminService adminService) {
		this.adminService = adminService;
	}
	
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/restricted")
    public String restricted() {
    	return "restricted";
    }
    
    @GetMapping("/admin")
    public String admin() {
    	adminService.ensureAdmin();
    	return "admin";
    }
}