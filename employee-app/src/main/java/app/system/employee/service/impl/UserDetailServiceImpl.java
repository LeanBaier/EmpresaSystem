package app.system.employee.service.impl;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final List<UserDetails> users;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserDetailServiceImpl() {
        this.users = new ArrayList<>();
        this.passwordEncoder = new BCryptPasswordEncoder();

        for (int i = 1; i <= 10; i++) {
            int finalI = i;
            this.users.add(new UserDetails() {
                @Override
                public Collection<? extends GrantedAuthority> getAuthorities() {
                    return List.of(new SimpleGrantedAuthority("ROLE_USER"));
                }

                @Override
                public String getPassword() {
                    return passwordEncoder.encode("pass" + finalI);
                }

                @Override
                public String getUsername() {
                    return "user" + finalI;
                }

                @Override
                public boolean isAccountNonExpired() {
                    return true;
                }

                @Override
                public boolean isAccountNonLocked() {
                    return true;
                }

                @Override
                public boolean isCredentialsNonExpired() {
                    return true;
                }

                @Override
                public boolean isEnabled() {
                    return true;
                }
            });
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.users.stream()
                         .filter(u -> u.getUsername().equals(username))
                         .findAny()
                         .orElseThrow(() -> new UsernameNotFoundException(username));
    }
}
