package com.rnlic.hraapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.rnlic.hraapp.service.MailingService;

@Controller
public class MailingServiceController {

	@Autowired
	private MailingService mailingService;
	
	@PostMapping("/sendMail")
    public String sendMail() {
		//mailingService.sendMail("sharnendradey@gmail.com");
		mailingService.sendMail2();
        return "Success";
    }
}
