package com.example.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.UserDTO;
import com.example.exception.ApplicationException;
import com.example.exception.DuplicateRecordException;
import com.example.exception.RecordNotFoundException;
import com.example.form.UserRegistrationForm;
import com.example.service.UserServiceInt;



@Controller
@RequestMapping(value="/ctl/User")
public class UserCtl extends BaseCtl{


	@Autowired
	private UserServiceInt userservice=null;
	
	
	
	
	@RequestMapping(value="/AddUser",method=RequestMethod.GET)
	public String displayUser(@RequestParam(required=false) Long id, @ModelAttribute("form") UserRegistrationForm form,BindingResult result,Model model){
		
		
		
 		if(id!=null && id>0){
			UserDTO dto = userservice.findByPk(id);
			dto.setConfirmPassword(dto.getPassword());
			form.populate(dto);
		}
		
		
		return "AddUserView1";
	}
	
	
	@RequestMapping(value="/AddUser",method=RequestMethod.POST)
	public String submitUser(@ModelAttribute("form") @Valid UserRegistrationForm form,BindingResult result,Model model){
		
		System.out.println("inside submit of user");
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()) || OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			
			  if(result.hasErrors()){
				  System.out.println("result error" + result.getAllErrors());
				  return "AddUserView1";
			  }
			  
			  
			  UserDTO dto = (UserDTO) form.getDTO();
			  
			 
			  
			  if(dto.getId()>0){
				  
				  try {
 					userservice.update(dto);
 					
					model.addAttribute("success", "User updated successfully");
					
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				  
			  }else{
				  try {
					   userservice.add(dto);
					
					   
					   model.addAttribute("success", "User added successfully");
					
				} catch (ApplicationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (DuplicateRecordException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					model.addAttribute("error", "user already exist");
				}
				  
			  }
			  
		}
		
		else if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			
			System.out.println("inside reset");
			return "redirect:/ctl/User/AddUser"; 
		}
		else if(OP_CANCEL.equalsIgnoreCase(form.getOperation())){
			return "redirect:/UserListCtl";
		}
		return "AddUserView1";
	}
	
	
		
	
	@RequestMapping(value="/UserList",method=RequestMethod.GET)
	public String displayList(@ModelAttribute("form") UserRegistrationForm form,BindingResult result,Model model){
		
		
		int pageNo=1;
		
		
		List list1 = userservice.search(null, form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list1);
		
		
		List next = userservice.search(null, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		
		return "UserListView1";
	}
	
	
	@RequestMapping(value="/UserList",method = RequestMethod.POST)
	public String submitList(@ModelAttribute("form")   UserRegistrationForm form,BindingResult result,Model model){
		
		System.out.println("inside submit of user list");
		
		
		
		
		if(result.hasErrors()){
			System.out.println("errors can be"+result.getAllErrors());
			return "UserListView1";
		}
		
		System.out.println("dddddd---------->");
		
		int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		int pageSize= form.getPageSize();
		
		List list = null;
		List next = null;
		
		UserDTO dto = (UserDTO) form.getDTO();
		
		if(OP_SEARCH.equalsIgnoreCase(form.getOperation())){
		
			System.out.println("hhhhhhhhhhhhhhh");
			pageNo=1;
		}
		else if(OP_PREVIOUS.equalsIgnoreCase(form.getOperation())){
			pageNo--;
		}
		else if(OP_NEXT.equalsIgnoreCase(form.getOperation())){
			pageNo++;
		}
		else if(OP_NEW.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/User/AddUser";
		}
		else if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/User/UserList";
		}
		
		else if(OP_DELETE.equalsIgnoreCase(form.getOperation())){
			
			System.out.println("inside delete of user list");
			
			if(form.getChk_1()!=null){
				
			for(Long id : form.getChk_1()){
				
				try {
					userservice.delete(id);
					
					model.addAttribute("success", "record deleted successfully");
					
				} catch (RecordNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
				
			}else{
				
			model.addAttribute("error", "record does not exist");
			}
		}
		
		/*else if(OP_BACK.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/User/UserList";
		}
		*/
		form.setPageNo(pageNo);
		
		list = userservice.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(form.getOperation())){
			
			
			model.addAttribute("error", "No record found");
		}
		
		next = userservice.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize", next.size());
				
		return "UserListView1";
	}
}
