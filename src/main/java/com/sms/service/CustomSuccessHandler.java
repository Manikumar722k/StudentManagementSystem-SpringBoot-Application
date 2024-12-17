package com.sms.service;

import java.io.IOException;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Service;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CustomSuccessHandler implements AuthenticationSuccessHandler{

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		var authourities = authentication.getAuthorities();
		var roles = authourities.stream().map(r -> r.getAuthority()).findFirst();
		
		if (roles.orElse("").equals("ADMIN")) {
			
			 response.sendRedirect("/loginReg");
			
			
		} else if (roles.orElse("").equals("USER")) {
			 response.sendRedirect("/user-page");
		}
		
		else {
			response.sendRedirect("/error");
		}
		
		
//		Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
//		if (roles.contains("ADMIN")) {
//            response.sendRedirect("/admin-page");
//        }
//		else if (roles.contains("USER")) {
//            response.sendRedirect("/user-page");
//        }
//		else {
//            response.sendRedirect("/error");
//        }
	}
}
