package com.rnlic.hraapp.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rnlic.hraapp.bean.JwtUser;
import com.rnlic.hraapp.security.JwtGenerator;
import com.rnlic.hraapp.security.Secured;

@RestController

public class TokenController {

    private JwtGenerator jwtGenerator;

    public TokenController(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("/token")
    public String generate(@RequestBody final JwtUser jwtUser) {

        return jwtGenerator.generate(jwtUser);

    }
    
    @PostMapping("/details")
    @Secured(indentify="GET_TOKEN_DETAILS_TEST")
    public String tokendetails(HttpServletRequest httpServletRequest)
    {
    	String header = httpServletRequest.getHeader("Authorization");
		return header;
    }
    
    
    @PostMapping("/service/sst")
    @Secured(indentify="GET_TOKEN_DETAILS_TEST_ALL")
    public String Seer(HttpServletRequest httpServletRequest)
    {
		return "fgfg";
    }
    
    @PostMapping("/unsecure/sst2")
    @Secured(indentify="GET_TOKEN_DETAILS_TEST")
    public String Seer2()
    {
		return "jhgjh";
    }
}
