package com.vcg.chat.oauth2.controller;

import com.alibaba.fastjson.JSONObject;
import com.vcg.chat.oauth2.model.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.provider.AuthorizationRequest;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.web.savedrequest.DefaultSavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by wuyu on 2016/8/29.
 */
@SessionAttributes("authorizationRequest")
@Controller
public class UserController {

    @Autowired
    private ClientDetailsService clientDetailsService;


    @Autowired
    private DefaultTokenServices tokenServices;

    @GetMapping(value = "/user")
    @ResponseBody
    public User user(@AuthenticationPrincipal User user) {
        return user;
    }

    @GetMapping(value = "/me")
    @ResponseBody
    public Object me(HttpServletRequest request, @AuthenticationPrincipal User user) {
        if (user != null) {
            return user;
        }
        String authorization = request.getHeader("Authorization");
        String access_token = null;
        if (authorization != null) {
            access_token = authorization.toLowerCase().replace("bearer", "").trim();
        }
        OAuth2Authentication oAuth2Authentication = tokenServices.loadAuthentication(access_token);
        if (oAuth2Authentication.getUserAuthentication() == null) {
            return oAuth2Authentication;
        }
        return oAuth2Authentication.getPrincipal();
    }


    @GetMapping(value = "/oauth/confirm_access")
    public ModelAndView confirmAccess(Map<String, Object> model) {
        return new ModelAndView("forward:/", model);
    }


    @GetMapping(value = "/user/company")
    @ResponseBody
    public JSONObject getCompany(Map<String, Object> model, HttpSession httpSession) {
        JSONObject json = new JSONObject();
        DefaultSavedRequest defaultSavedRequest = (DefaultSavedRequest) httpSession.getAttribute("SPRING_SECURITY_SAVED_REQUEST");
        AuthorizationRequest authorizationRequest = (AuthorizationRequest) model.get("authorizationRequest");
        if (defaultSavedRequest != null && defaultSavedRequest.getParameterValues("client_id") != null
                && defaultSavedRequest.getParameterValues("client_id").length > 0) {
            String[] client_ids = defaultSavedRequest.getParameterValues("client_id");
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(client_ids[0]);
            Object company = clientDetails.getAdditionalInformation().get("company");
            Object loginType = clientDetails.getAdditionalInformation().get("loginType");
            String redirectUrl = defaultSavedRequest.getRedirectUrl();
            json.put("redirectUrl", redirectUrl);
            json.put("company", company);
            json.put("loginType", loginType);
        } else if (authorizationRequest != null && authorizationRequest.getClientId() != null) {
            String clientId = authorizationRequest.getClientId();
            ClientDetails clientDetails = clientDetailsService.loadClientByClientId(clientId);
            Object company = clientDetails.getAdditionalInformation().get("company");
            Object loginType = clientDetails.getAdditionalInformation().get("loginType");
            String redirectUrl = authorizationRequest.getRedirectUri();
            json.put("redirectUrl", redirectUrl);
            json.put("company", company);
            json.put("loginType", loginType);
        } else {
            json.put("company", "vc-chat");
        }
        return json;

    }

}
