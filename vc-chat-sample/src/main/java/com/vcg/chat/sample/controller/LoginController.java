package com.vcg.chat.sample.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;

/**
 * Created by wuyu on 2016/9/10.
 */
@Controller
@Slf4j
public class LoginController {

    @RequestMapping("/login")
    public String dashboard() {
        return "redirect:/#/";
    }

    @RequestMapping(value = "/me")
    @ResponseBody
    public Principal me(Principal principal) {
        return principal;
    }

    @RequestMapping(value = "logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            log.debug("Invalidating session: " + session.getId());
            session.invalidate();
        }

        SecurityContext context = SecurityContextHolder.getContext();
        context.setAuthentication(null);

        SecurityContextHolder.clearContext();
        return "redirect:/";
    }

}
