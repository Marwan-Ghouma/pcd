package net.codejava;

import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AppController {

	@Autowired
	private UserServices service;
	
	@GetMapping("")
	public String viewHomePage() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		if (authentication == null || authentication instanceof AnonymousAuthenticationToken) {


			return "index";
		}

		return "redirect:/users";

	}



	@GetMapping("/role")
	public String redirect(HttpServletRequest request) {
		if (request.isUserInRole("ROLE_User")) {
			return "redirect:http://localhost:4200/profile/page";
		}
			return "redirect:http://localhost:4200/contact";

		}
	
	@GetMapping("/register")
	public String showRegistrationForm(Model model) {

			model.addAttribute("user", new User());

			return "signup_form";


	}



	
	@PostMapping("/process_register")
	public String processRegister(User user, HttpServletRequest request) 
			throws UnsupportedEncodingException, MessagingException {
		service.register(user, getSiteURL(request));		
		return "register_success";
	}
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		List<User> listUsers = service.listAll();
		model.addAttribute("listUsers", listUsers);
		
		return "users";
	}
	
	private String getSiteURL(HttpServletRequest request) {
		String siteURL = request.getRequestURL().toString();
		return siteURL.replace(request.getServletPath(), "");
	}	
	
	@GetMapping("/verify")
	public String verifyUser(@Param("code") String code) {
		if (service.verify(code)) {
			return "verify_success";
		} else {
			return "verify_fail";
		}
	}






}
