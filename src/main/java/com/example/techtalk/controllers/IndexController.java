package com.example.techtalk.controllers;

import com.example.techtalk.domain.Presentation;
import com.example.techtalk.service.TechTalkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;
import util.UserNameLdapUtil;

import java.security.Principal;
import java.time.LocalDate;
import java.util.List;

@Controller
public class IndexController implements ErrorController {

    @Autowired
    TechTalkService service;

    String userName;

    UserNameLdapUtil userNameLdapUtil = new UserNameLdapUtil();

    @RequestMapping("/")
    String index(Model model, Principal principal) {
        Long count = service.getCountPresentation();
        model.addAttribute("count", count);
        userName = userNameLdapUtil.getUserNameLdap();
        model.addAttribute("userName", userName);
        return "tthome";
    }

    @RequestMapping("/presentation")
    String getPresentations(Model model) {
        List<Presentation> presentations = service.getPresentations();
        model.addAttribute("presentations", presentations);
        return "infoSection/techTalk";
    }

    @PostMapping("/presentation")
    String addPresentation(Presentation presentation, Model model) {
        presentation.setPresenter(userName);
        try {
            service.addPresentation(presentation);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        return "redirect:/";
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
