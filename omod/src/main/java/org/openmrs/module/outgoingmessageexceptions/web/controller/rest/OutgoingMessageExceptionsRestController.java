package org.openmrs.module.outgoingmessageexceptions.web.controller.rest;

import org.openmrs.module.outgoingmessageexceptions.OutgoingMessage;
import org.openmrs.module.outgoingmessageexceptions.api.OutgoingMessageExceptionsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller("${artifactid}.OutgoingMessageExceptionsRestController")
@RequestMapping(value = "/rest/isanteplus")
public class OutgoingMessageExceptionsRestController {
	
	private final Logger logger = LoggerFactory.getLogger(OutgoingMessageExceptionsRestController.class);
	
	@Autowired
	OutgoingMessageExceptionsService outgoingMessageExceptionsService;
	
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	@ResponseBody
	public String getMessage(@RequestParam(value = "uniqueID", required = true) String uniqueID,
							 @RequestBody(required = false) String body, HttpServletRequest request, HttpServletResponse response) {
		logger.debug("Get Single message reached");
		return uniqueID + " " + body;
	}
	
	@RequestMapping(value = "/messages", method = RequestMethod.GET)
	@ResponseBody
	public String getMessages(@RequestParam(value = "v", required = false) String scope, HttpServletRequest request,
	        HttpServletResponse response) {
		logger.debug("Get all messages reached");
		return scope;
	}
	
	@RequestMapping(value = "/messages/{id}", method = RequestMethod.GET)
	@ResponseBody
	public OutgoingMessage getMessageById(@PathVariable Integer id) {
		logger.debug("Get Single message reached by message id");
		return outgoingMessageExceptionsService.getMessageById(id);
	}
}