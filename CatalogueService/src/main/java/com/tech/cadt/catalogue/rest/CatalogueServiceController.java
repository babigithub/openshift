package com.tech.cadt.catalogue.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tech.cadt.start.CatalogueService;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/catalogueService")
@Component
@CrossOrigin
public class CatalogueServiceController   extends SpringBootServletInitializer {

private static final Logger LOGGER = LoggerFactory.getLogger(CatalogueServiceController.class);
String customlogger ="ADMS Loger::::";

	
    private static final String signingKey = "signingKey";
 	
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	@CrossOrigin
	public @ResponseBody List<String> authenticateCustomer(HttpServletResponse httpServletResponse, @RequestHeader HttpHeaders headers,@RequestBody String userCredentials) {

		LOGGER.info(customlogger+"userCredentials::" + userCredentials);
		JSONObject userCredjson = null;
		CatalogueService customerObj = null;
		String username = null;
		CatalogueService customerresultObj = null ;
		boolean validation =false;
		LOGGER.info(customlogger+"Header Object in Customer Service::::::"+headers);
		List<String> token = headers.get("jwtToken");
		LOGGER.info("JWT token:::::"+token.get(0));
		String listObj = token.get(0);
	    String jwtUsername = JwtUtil.getSubject(httpServletResponse, listObj, signingKey);
	    String jwtPassword = JwtUtil.getPassword(httpServletResponse, listObj, signingKey);
	    LOGGER.info(customlogger+"Jwt User credentials after Parsing:::::");
	    LOGGER.info(customlogger+"username::"+jwtUsername);
	    LOGGER.info(customlogger+"password::"+jwtPassword);
	    System.out.println("token"+token);
	   
		try {
			
			if (jwtUsername != null) {
				
				if ((jwtPassword.equals("admin")) && 
						jwtUsername.equals("admin")) {
					validation = true;
					LOGGER.info(customlogger+"JWT Token Validataion Sucessful in customer Service.");
				} else {
					LOGGER.info(customlogger+"JWT Token Validataion failed in customer Service.");
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
