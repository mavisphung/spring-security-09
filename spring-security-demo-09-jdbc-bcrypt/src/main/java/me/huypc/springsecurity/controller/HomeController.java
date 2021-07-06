package me.huypc.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String showHome() {
		return "home";
	}

	// thêm request mapping cho /leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}

	// thêm request mapping cho /systems
	@GetMapping("/systems")
	public String showSystems() {
		return "systems";
	}
	
	//xử lí khi mà không thể authorize (xác thực quyền)
	@GetMapping("/access-denied")
	public String showAccessDeniedPage() {
		return "access-denied";
	}
}
