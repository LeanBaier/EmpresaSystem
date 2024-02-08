package app.system.employee.controller;

import app.system.employee.dto.request.RegisterLoginRequestDTO;
import app.system.employee.dto.response.RegisterLoginResponseDTO;
import app.system.employee.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/auth")
@Validated
public class AuthApiController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<RegisterLoginResponseDTO> login(
            @RequestBody
            @Valid RegisterLoginRequestDTO request) {
        RegisterLoginResponseDTO result = authService.login(request);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterLoginResponseDTO> register(
            @RequestBody @Valid RegisterLoginRequestDTO request) {
        RegisterLoginResponseDTO result = authService.register(request);
        return ResponseEntity.ok(result);
    }

}
