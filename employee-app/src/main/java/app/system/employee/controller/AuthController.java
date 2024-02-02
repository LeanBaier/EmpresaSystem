package app.system.employee.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {


    @GetMapping("/login")
    public String auth(@RequestParam(required = false, defaultValue = "false") boolean error, Model model) {
        model.addAttribute("error", error);
        model.addAttribute("fragmentName", "auth/login");
        model.addAttribute("fragmentTag", "main");
        return "general";
    }

}