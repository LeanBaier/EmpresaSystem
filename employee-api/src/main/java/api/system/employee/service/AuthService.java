package api.system.employee.service;

import api.system.employee.dto.request.RegisterLoginRequestDTO;
import api.system.employee.dto.response.RegisterLoginResponseDTO;

public interface AuthService {

    RegisterLoginResponseDTO login(RegisterLoginRequestDTO request);
    RegisterLoginResponseDTO register(RegisterLoginRequestDTO request);

}
