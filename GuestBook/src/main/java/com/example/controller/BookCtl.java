package com.example.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.captcha.botdetect.web.servlet.Captcha;
import com.example.dto.BookDTO;
import com.example.dto.UserDTO;
import com.example.exception.RecordNotFoundException;
import com.example.form.BookForm;
import com.example.form.UserRegistrationForm;
import com.example.service.BookAppServiceInt;

@Controller
@RequestMapping(value="/ctl/Book")
public class BookCtl extends BaseCtl{

	@Autowired
	private BookAppServiceInt bookService=null;
	
	/*@Autowired
	@Qualifier("contactValidator")
	private Validator validator;
	
	
	  @InitBinder
	  private void initBinder(WebDataBinder binder) {
	    binder.setValidator(validator);
	  }*/
	
	@RequestMapping(value="/AddBook",method=RequestMethod.GET)
	public String displayUser(@RequestParam(required=false) Long id, @ModelAttribute("form") BookForm form,BindingResult result,Model model){
		
		
		
 		if(id!=null && id>0){
			BookDTO dto = bookService.findByPk(id);
			form.populate(dto);
		}
		
		
		return "AddBookView1";
	}
	
	
	@RequestMapping(value="/AddBook",method=RequestMethod.POST)
	public String submitUser(HttpServletRequest request,@ModelAttribute("form") @Valid BookForm form,BindingResult result,Model model){
		
		System.out.println("inside submit of Book");
		System.out.println("name------>"+form.getFirstName());
		System.out.println("file------>"+form.getFile());
		
		MultipartFile ob = form.getFile();
		
		
		Map<String, String> messages = new HashMap<String, String>();
	    request.setAttribute("messages", messages);

	    // validate the Captcha to check we're not dealing with a bot
	    Captcha captcha = Captcha.load(request, "exampleCaptchaTag");
	    boolean isHuman = captcha.validate(request.getParameter("captchaCode"));
	    if (!isHuman) {
	      // Captcha validation failed, show error message
	      messages.put("captchaIncorrect", "Incorrect code");
	      return "AddBookView1";
	    } 
		
		
		
		if(OP_SAVE.equalsIgnoreCase(form.getOperation()) || OP_UPDATE.equalsIgnoreCase(form.getOperation())){
			
			  if(result.hasErrors()){
				  System.out.println("result error" + result.getAllErrors());
				  return "AddBookView1";
			  }
			  
			  
			  
			  
			  BookDTO dto = new BookDTO();
			  
			  dto.setFirstName(form.getFirstName());
			  dto.setLastName(form.getLastName());
			  dto.setEmail(form.getEmail());
			  dto.setPhoneNumber(form.getPhoneNumber());
			  dto.setFileName(ob.getOriginalFilename());
			  try {
				dto.setData(ob.getBytes());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 
			  Date d = new Date();
			  System.out.println("date is--->"+d.getTime());
			 dto.setCreatedDateTime(new Timestamp(d.getTime())); 
			  
			 
			 
			 
			  HttpSession session = request.getSession();
			  session.removeAttribute("captchaVerified");
			  
			  
			  if(dto.getId()>0){
				  bookService.update(dto);
					
					model.addAttribute("success", "Book updated successfully");
				  
			  }else{
				  
					   bookService.add(dto);
					
					   
					   model.addAttribute("success", "Book added successfully");
					
				
				  
			  }
			  
		}
		
		else if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			
			System.out.println("inside reset");
			return "redirect:/ctl/Book/AddBook"; 
		}
		else if(OP_CANCEL.equalsIgnoreCase(form.getOperation())){
			return "redirect:/BookListCtl";
		}
		
		return "AddBookView1";
	}
	
	
	
	@RequestMapping(value="/BookList",method=RequestMethod.GET)
	public String displayList(@ModelAttribute("form") BookForm form,BindingResult result,Model model){
		
		
		int pageNo=1;
		
		
		List list1 = bookService.search(null, form.getPageNo(), form.getPageSize());
		model.addAttribute("list", list1);
		
		
		List next = bookService.search(null, pageNo+1, form.getPageSize());
		model.addAttribute("nextlistsize", next.size());
		
		
		return "BookListView1";
	}
	
	
	@RequestMapping(value="/BookList",method = RequestMethod.POST)
	public String submitList(@ModelAttribute("form")   BookForm form,BindingResult result,Model model){
		
		System.out.println("inside submit of Book list");
		
		
		
		
		if(result.hasErrors()){
			System.out.println("errors can be"+result.getAllErrors());
			return "BookListView1";
		}
		
			
		int pageNo = (form.getPageNo()==0)?1:form.getPageNo();
		int pageSize= form.getPageSize();
		
		List list = null;
		List next = null;
		
		BookDTO dto = (BookDTO) form.getDTO();
		
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
			return "redirect:/ctl/Book/AddBook";
		}
		else if(OP_RESET.equalsIgnoreCase(form.getOperation())){
			return "redirect:/ctl/Book/BookList";
		}
		
		else if(OP_DELETE.equalsIgnoreCase(form.getOperation())){
			
			System.out.println("inside delete of user list");
			
			if(form.getChk_1()!=null){
				
			for(Long id : form.getChk_1()){
				
				bookService.delete(id);
				
				model.addAttribute("success", "record deleted successfully");

			}
				
			}else{
				
			model.addAttribute("error", "record does not exist");
			}
		}
		
		
		form.setPageNo(pageNo);
		
		list = bookService.search(dto, pageNo, pageSize);
		model.addAttribute("list", list);
		
		if(list.size()==0 && !OP_DELETE.equalsIgnoreCase(form.getOperation())){
			
			
			model.addAttribute("error", "No record found");
		}
		
		next = bookService.search(dto, pageNo+1, pageSize);
		model.addAttribute("nextlistsize", next.size());
				
		return "BookListView1";
	}

	
}
