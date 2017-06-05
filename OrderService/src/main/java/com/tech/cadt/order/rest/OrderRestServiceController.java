package com.tech.cadt.order.rest;

import java.util.List;

import javax.persistence.criteria.Order;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.tech.cadt.order.rest.JwtUtil;

@RestController
@RequestMapping("/orders")
@CrossOrigin
public class OrderRestServiceController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrderRestServiceController.class);
    private static final String signingKey = "signingKey";
	



	
	
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value="/createOrder", method = RequestMethod.POST)
	@CrossOrigin
	public  @ResponseBody List<String>  createnewOrder(HttpServletResponse httpServletResponse,@RequestHeader HttpHeaders headers) {

		 LOGGER.info("Inside createnewOrder() new Order Details::");
		 RestTemplate restTemplate = new RestTemplate();
		 Order resultObj = null ;
	
			
			String usernameVal = null;
		
			LOGGER.info("Headers::::::" + headers);
			List<String> token = headers.get("jwtToken");
			LOGGER.info("JWT token:::::" + token.get(0));
			String listObj = token.get(0);
			String jwtUsername = JwtUtil.getSubject(httpServletResponse,listObj, signingKey);
			String jwtPassword = JwtUtil.getSubject(httpServletResponse,listObj, signingKey);
			LOGGER.info("::::::Jwt User credentials after Parsing:::::");
			LOGGER.info("username::" + jwtUsername);
			LOGGER.info("password::" + jwtPassword);

		
			LOGGER.info("Customer Object from Customer Service ::::");
		
			try {
				
				boolean validation=false;
				if (jwtUsername != null) {
					// Comapare the object from database and de copuled details from JWT Token details ..
					if ((jwtPassword.equals("admin")) && 
							jwtUsername.equals("admin")) {
						validation = true;
						LOGGER.info("JWT Token Validataion Sucessful in customer Service.");
					} else {
						LOGGER.info("JWT Token Validataion failed in customer Service.");
						validation = false;
					}
				} else {
					validation = false;
				}

				
				
			} catch (Exception e) {
				
			}
			return token;
				
		
}
		 @RequestMapping("/")
		 @CrossOrigin
		    public String home(){
		        return "redirect:/login";
		    }

	}