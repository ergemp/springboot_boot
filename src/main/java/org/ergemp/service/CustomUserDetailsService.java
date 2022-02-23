package org.ergemp.service;

import org.ergemp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
CustomUserDetailsService implements the Spring Security UserDetailsService interface.
It overrides the loadUserByUsername for fetching user details from the database using the username.

The Spring Security Authentication Manager calls this method for getting the user details
from the database when authenticating the user details provided by the user.

Here we are getting the user details from a hardcoded User List
*/
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<org.ergemp.model.User> users = userRepository.findByName(username);
        if (users.size() == 1) {
            return new User(users.get(0).getUsername(), users.get(0).getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("Invalid Credentials: " + username);
        }
    }

    public UserDetails loadUserByUser(org.ergemp.model.User user) throws UsernameNotFoundException {
        List<org.ergemp.model.User> users = userRepository.findByUsernamePassword(user.getUsername(), user.getPassword());
        if (users.size() == 1) {
            return new User(users.get(0).getUsername(), users.get(0).getPassword(), new ArrayList<>());
        }
        else {
            throw new UsernameNotFoundException("Invalid Credentials: " + user.toString());
        }
    }

}