package com.bitMiners.pdf.controllers;

import com.bitMiners.pdf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;

@SessionAttributes({"currentUser", "currentUserId"})
@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
    public String loginerror(Model model) {

        model.addAttribute("error", "true");
        return "login";
    }

    @RequestMapping("/error-forbidden")
    public String errorForbidden() {
        return "error-forbidden";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(Model model, SessionStatus session) {
        SecurityContextHolder.getContext().setAuthentication(null);
        session.setComplete();
        return "redirect:/welcome";
    }

    @RequestMapping(value = "/postLogin", method = RequestMethod.POST)
    public String postLogin(String username, String password, Model model, HttpSession session) {
        if (username == null || password == null) {
            model.addAttribute("message", "None of field can be empty");
        }
        boolean isCorrect = userService.isCorrectUsernameAndPassword(username, password);
        if (isCorrect) {
            model.addAttribute("currentUserId", userService.getUserByUsername(username).getId());
            model.addAttribute("currentUser", username);
            session.setAttribute("userId", userService.getUserByUsername(username).getId());
            return "redirect:/wallPage";
        }
        model.addAttribute("message", "Username or password didn't matched");
        return "login";
    }
}