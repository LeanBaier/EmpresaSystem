package api.system.employee.controller;

import api.system.employee.dto.request.RegisterLoginRequestDTO;
import api.system.employee.dto.response.RegisterLoginResponseDTO;
import api.system.employee.service.AuthService;
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
