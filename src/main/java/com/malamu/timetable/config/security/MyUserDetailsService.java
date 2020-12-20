package com.malamu.timetable.config.security;


import com.malamu.timetable.models.Users;
import com.malamu.timetable.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
       Optional<Users> systemUser= userRepository.findByEmail(userName);

       systemUser.orElseThrow(()->new UsernameNotFoundException("Not Found: "+userName));
       return  systemUser.map(MyUserDetails::new).get();

    }
}
