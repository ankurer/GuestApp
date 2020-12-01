package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.form.LoginForm;
import com.example.form.UserRegistrationForm;
import com.example.service.UserServiceInt;


@Controller
public class LoginCtl extends BaseCtl{

	/**
	 * Operations
	 */
	protected static final String OP_SIGNIN = "SignIn";
    protected static final String OP_SIGNUP = "SignUp";
    
    @Autowired
    private UserServiceInt userservice=null; 
    
     
    @RequestMapping(value="/Login",method=RequestMethod.GET)
    public String display(@ModelAttribute("form") LoginForm form , HttpSession session,Model model){
    	
    	if(session.getAttribute("user")!=null){
    		
    		session.invalidate();
    		
    		model.addAttribute("success", "log out successfully");
    	}
    	
    	return "LoginView";
    }
    
  
    @RequestMapping(value="/Login",method=RequestMethod.POST)
    public String submit(@ModelAttribute("form") @Valid LoginForm form,BindingResult result,HttpSession session,HttpServletRequest request,Model model){
    	
    	System.out.println("inside post");
    	
    	if(OP_SIGNIN.equalsIgnoreCase(form.getOperation())){
    		
    		if(result.hasErrors())
    		{
    		  return "LoginView";
    		}
    		
    		
    		UserDTO dto = new UserDTO();
    		
    		System.out.println("email id is"+form.getEmailId());
    		System.out.println("password is"+form.getPassword());
    		
    		
    		dto.setLogin(form.getEmailId());
    		dto.setPassword(form.getPassword());
    		
    		
    		dto= userservice.authenticate(dto.getLogin(), dto.getPassword());
    		
    		if(dto!=null){
    		
    			UserDTO edto = userservice.findByPk(dto.getId());
    			
    			  try {
					userservice.update(edto);
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
    			
    			  
    			  session.setAttribute("user", dto);
   
    			      			  System.out.println(" firstname & lastname"+dto.getFirstName()+ " "+dto.getLastName());
    			  
    			  System.out.println("front ctl uri code----------->");
    			  if(form.getUri()==null || form.getUri()==""){
    			  
    				  
    			  return "redirect:/Welcome";
    			  }else{
    				  
    				  System.out.println("inside else of uri--------->");
    				  //return "redirect:/"+form.getUri().replace("/GuestBook/","");
    			  
    				  return "redirect:/Welcome";
    			  }
    			
    		}else{
    			
    			model.addAttribute("error", "login failed");
    		}
    		
    	}else if(OP_SIGNUP.equalsIgnoreCase(form.getOperation())){
    		
    		return "redirect:/UserRegistration";
    	}
    	
    	
    	return "LoginView";
    }
    
      
    
    
    
    
    @RequestMapping(value="/UserRegistration",method=RequestMethod.GET)
    public String display(@ModelAttribute("form") UserRegistrationForm form,Model model){
    	
    	    
    	return "UserRegistrationView";
    }
    
    
    @RequestMapping(value="/UserRegistration",method=RequestMethod.POST)
    public String submit(@ModelAttribute("form") @Valid UserRegistrationForm form,BindingResult result,Model model){
    	 
    	
    	System.out.println("inside user registration of submit");
    	
    	if(OP_SIGNUP.equalsIgnoreCase(form.getOperation())){
    		
    		   if(result.hasErrors()){
    			   return "UserRegistrationView";
    		   }
    		
    		
    		   UserDTO dto = (UserDTO) form.getDTO();
    		   
    		  System.out.println("dob ---------->"+form.getDob());
    		   
    		   
    		   try {
				userservice.add(dto);
				System.out.println("registration successfull");
				
				model.addAttribute("success", "user registered successfully");
				//form.populate(dto);
				return "UserRegistrationView";
				
			} catch (ApplicationException e) {
				
				model.addAttribute("error", "User already registered");

				
			} catch (DuplicateRecordException e) {
								
					model.addAttribute("error", "User already registered");
			}
    		   return "redirect:/UserRegistrationView"; 
    		   
    	}
    	
    	if(OP_RESET.equalsIgnoreCase(form.getOperation())){
    		return "redirect:/UserRegistration";
    	}
    	
    	return "UserRegistrationView";
    }
    
}
