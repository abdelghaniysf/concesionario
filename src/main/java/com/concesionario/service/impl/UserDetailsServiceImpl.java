package com.concesionario.service.impl;



import com.concesionario.entity.user.UserEntity;
import com.concesionario.repository.IUserEntityRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional()
public class UserDetailsServiceImpl implements UserDetailsService {

    private final IUserEntityRepository userRepository;

    public UserDetailsServiceImpl(IUserEntityRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("User not found"));

        List<SimpleGrantedAuthority> grantedAuthorities = user.getRoleEntities().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole().name())).toList();

        UserDetails userDetails =new User(user.getUsername(),user.getPassword(),grantedAuthorities);
        return userDetails;
    }
}
