package app.system.employee.service.impl;

import app.system.employee.dto.request.RegisterLoginRequestDTO;
import app.system.employee.dto.response.RegisterLoginResponseDTO;
import app.system.employee.model.SyUserModel;
import app.system.employee.repository.SyUserRepository;
import app.system.employee.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AuthServiceImpl implements AuthService {

    private final SyUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtServiceImpl jwtService;

    @Override
    public RegisterLoginResponseDTO login(RegisterLoginRequestDTO request) {
        SyUserModel user = userRepository.findById(request.getUsername())
                                         .orElseThrow(() -> new UsernameNotFoundException(request.getUsername()));

        List<GrantedAuthority> grants = new ArrayList<>();
        user.getRoles()
            .forEach(r -> r.getGrants()
                           .forEach(g -> grants.add(new SimpleGrantedAuthority(g.getName()))));

        return RegisterLoginResponseDTO.builder()
                                       .accessToken("Bearer " + jwtService.generateToken(new User(request.getUsername(), request.getPassword(), grants)))
                                       .build();
    }

    @Override
    public RegisterLoginResponseDTO register(RegisterLoginRequestDTO request) {
        if (userRepository.existsById(request.getUsername())) {
            throw new RuntimeException("El usuario ya esta registrado");
        }

        userRepository.save(SyUserModel.builder()
                                       .password(passwordEncoder.encode(request.getPassword()))
                                       .username(request.getUsername())
                                       .email("email@email.com")
                                       .build());

        return RegisterLoginResponseDTO.builder().accessToken("TOKEN").build();
    }
}
