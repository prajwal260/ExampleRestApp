package com.rest.webservices.restfulwebservices.HelloWorld;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class HelloWorldController {
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping(path = "/hello-world")
	public String helloWorld() {
		return "Hello World Spring";
	}

	@GetMapping(path = "/hello")
	public HelloWorldBean helloWorldBean() {
		return new HelloWorldBean("Hello World");
	}

	
	  // /hello-world/path-variable/in28minutes
	  
	  @GetMapping(path= "/hello-world/path-variable/{name}") 
	  public HelloWorldBean helloWorldPathVariable(@PathVariable String name) 
	  { 
		  return new HelloWorldBean(String.format("Hello World, %s", name)); 
	  }
	  
		@GetMapping(path = "/hello-world-internationalized")
		public String helloWorldInternationalized(
				//@RequestHeader(name="Accept-Language",required=false) Locale locale
				){
			
			return messageSource
					.getMessage("good.morning.message",null,"Default Message",//locale);
							LocaleContextHolder.getLocale());
			//return "Hello World";
		}
	 
}
