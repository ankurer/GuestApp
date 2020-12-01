package com.example.controller;

import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


public class FrontCtl extends HandlerInterceptorAdapter{

	
	@Override
	public boolean preHandle(HttpServletRequest request,HttpServletResponse response,Object handler) throws ServletException, IOException{
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("user")==null){
		
		Locale locale = null;
		
		//String msg = messageSource.getMessage("message.session", null, locale);
		request.setAttribute("error", "Your session expired");
		
		String str= request.getRequestURI();
		
		request.setAttribute("URI", str);
		
		System.out.println("inside frontctl uri is-------->"+str);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Login");
		rd.forward(request, response);
		return false;
		}
		return true;
	}
}
