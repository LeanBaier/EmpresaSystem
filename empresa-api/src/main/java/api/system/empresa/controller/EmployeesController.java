package api.system.empresa.controller;

import api.system.empresa.dto.GetEmployeesRequest;
import api.system.empresa.service.EmployeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;
import java.util.Objects;

@RequiredArgsConstructor
@Controller
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployeeService employeeService;

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("serverTime", new Date());
        return "employees/home";
    }

    @GetMapping("/search")
    public String searchView(Model model) {
        GetEmployeesRequest filters = (GetEmployeesRequest) model.getAttribute("filters");
        if (Objects.isNull(filters)) {
            filters = buildDefaultFilters();
        }
        var employeeModelList = employeeService.getEmployees(filters);
        model.addAttribute("employees", employeeModelList);
        model.addAttribute("filters", filters);
        return "employees/search";
    }

    @PostMapping("/search")
    public String getEmployeesByFilters(@ModelAttribute("filters")
                                        @Valid
                                        GetEmployeesRequest filters, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            filters = buildDefaultFilters();
        }
        var employeeModelList = employeeService.getEmployees(filters);
        model.addAttribute("employees", employeeModelList);

        return "employees/search";
    }

    private GetEmployeesRequest buildDefaultFilters() {
        return GetEmployeesRequest.builder()
                                  .page(1)
                                  .size(20)
                                  .order("ASC")
                                  .build();

    }
}
