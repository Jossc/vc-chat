package com.vcg.chat.oauth2.service;

import com.vcg.chat.oauth2.model.Authorities;
import com.vcg.chat.oauth2.model.User;
import com.vcg.chat.oauth2.repositories.AuthoritiesRepository;
import com.vcg.chat.oauth2.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * created by wuyu on 2018/3/6
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthoritiesRepository authoritiesRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null) throw new UsernameNotFoundException("username not found!");
        Authorities authorities = authoritiesRepository.findById(user.getId());
        if (authorities != null && !StringUtils.isEmpty(authorities.getAuthority())) {
            Set<SimpleGrantedAuthority> authoritySet = Stream.of(authorities.getAuthority().split(","))
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toSet());
            user.setAuthorities(authoritySet);
        }
        return user;
    }

    public User findNicknameAndAvatarAndIdById(Long id) {
        return userRepository.findNicknameAndAvatarAndIdById(id);
    }

}


