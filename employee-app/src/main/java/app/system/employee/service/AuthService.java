package app.system.employee.service;

import app.system.employee.dto.request.RegisterLoginRequestDTO;
import app.system.employee.dto.response.RegisterLoginResponseDTO;

public interface AuthService {

    RegisterLoginResponseDTO login(RegisterLoginRequestDTO request);
    RegisterLoginResponseDTO register(RegisterLoginRequestDTO request);

}
