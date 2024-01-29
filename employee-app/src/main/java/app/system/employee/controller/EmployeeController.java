package app.system.employee.controller;

import app.system.employee.dto.GetEmployeesRequest;
import app.system.employee.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
        return "employees/home";
    }

    @GetMapping("/search")
    public String searchView(@Valid @ModelAttribute("filters")
                             GetEmployeesRequest filters, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "employees/search";
        }
        if (model.containsAttribute("filters.size") && !model.getAttribute("filters.size").equals(filters.getSize().toString())) {
            filters.setSize((Integer) model.getAttribute("filters.size"));
        }
        var employeeModelList = employeeService.getEmployees(filters);
        model.addAttribute("employees", employeeModelList);
        return "employees/search";
    }

}
