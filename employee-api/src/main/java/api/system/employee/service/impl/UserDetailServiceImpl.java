package api.system.employee.service.impl;

import api.system.employee.model.SyUserModel;
import api.system.employee.repository.SyUserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {

    private final SyUserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        SyUserModel user = userRepository.findById(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));

        List<SimpleGrantedAuthority> grants = new ArrayList<>();
        user.getRoles().forEach(r -> r.getGrants().forEach(g -> grants.add(new SimpleGrantedAuthority(r.getDescription()))));

        return new User(user.getUsername(), user.getPassword(), grants);
    }
}
