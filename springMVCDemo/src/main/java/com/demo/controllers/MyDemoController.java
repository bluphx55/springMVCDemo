package com.demo.controllers;

import java.io.FileOutputStream;
import java.util.Random;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.demo.model.Account;

@Controller
public class MyDemoController {
	
	
	private String[] quotes = {"To be or not to be - Shakespeare",
							 	"Spring is nature's way of saying 'Let's Party' - Robin Williams",
							 	"the tiem is always right to do what is right - Martin Luther King, Jr"	};
	
	//http://localhost:8080/springMVCDemo/getQuote.html
//	@RequestMapping(value="/getQuote", params="from=red")
//	@RequestMapping(value="/getQuote", headers="X-API-KEY")
	@RequestMapping(value="/getQuote")	
	public String getRandomQuote(@RequestParam("userName") String userName, Model model) {
		
		System.out.println("URL Mapped Successfully");
		
		int rand = new Random().nextInt(quotes.length);
		String randomQuote = quotes[rand];
		
		model.addAttribute("randomQuote", randomQuote);
		
		System.out.println("Username is: " + userName);
		model.addAttribute("userName", userName);
		
		return "quote";
	}
	
//	@RequestMapping(value="/createAccount")
//	public String createAccount(@Valid @ModelAttribute ("aNewAccout") Account account, BindingResult result){
//		
//		if(result.hasErrors()){
//			System.out.println("Form has errors");
//			return "createAccount";
//		}
//		
//		System.out.println("Form validated");
//		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress() + " " + account.getEmail());
//		
//		return "createAccount";
//	}

	
	@RequestMapping(value="/createAccount")
	public String createAccount(@ModelAttribute ("aNewAccount") Account account) {
		return "createAccount";
	}
	
	@RequestMapping(value="/accountCreate", method=RequestMethod.POST)
	public String peformCreate(Account account){
		System.out.println(account.getFirstName() + " " + account.getLastName() + " " + account.getAddress() + " " + account.getEmail());
	
		return "accountCreate"; 
	}
	
	@RequestMapping(value="/myForm")
	public String myForm(){
		return "myForm";
	}
	
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file){
		try{
			if (!file.isEmpty()){
				byte[] bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream("E:\\Programming\\demo\\testFile.jpg");
				fos.write(bytes);
				fos.close();
				System.out.println("File saved successfully");
			} else {
				System.out.println("No file available to save.");
			}
			
		} catch(Exception e){
			System.out.println("Error saving the file.");
		}
		 
		
		return "operationComplete";
	}
	
	
}
