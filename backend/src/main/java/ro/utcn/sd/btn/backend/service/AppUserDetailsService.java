package ro.utcn.sd.btn.backend.service;



import lombok.RequiredArgsConstructor;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.utcn.sd.btn.backend.model.User;
import ro.utcn.sd.btn.backend.persistence.api.RepositoryFactory;


import java.util.Collections;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {
    private final RepositoryFactory repository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = repository.createUserRepository().findByName(username);
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))) {
        };
    }

    @Transactional
    public User loadCurrentUser() {
        String name = SecurityContextHolder.getContext().getAuthentication().getName();
        return repository.createUserRepository().findByName(name);
    }

}
