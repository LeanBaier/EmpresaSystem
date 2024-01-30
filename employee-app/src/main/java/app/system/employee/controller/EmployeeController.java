package app.system.employee.controller;

import app.system.employee.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("serverTime", new Date());
        model.addAttribute("fragmentName", "employees/home");
        model.addAttribute("fragmentTag", "main");
        return "general";
    }

    @GetMapping("/search")
    public String searchView(Model model) {
        model.addAttribute("fragmentName", "employees/search");
        model.addAttribute("fragmentTag", "main");
        return "general";
    }

}
