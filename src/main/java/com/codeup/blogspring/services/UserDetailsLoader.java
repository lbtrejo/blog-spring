package com.codeup.blogspring.services;

import com.codeup.blogspring.models.User;
import com.codeup.blogspring.models.UserWithRoles;
import com.codeup.blogspring.repos.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final Users usersDao;

    public UserDetailsLoader(Users usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = usersDao.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user found for " + username);
        }

        // Users the new copy constructor
        return new UserWithRoles(user);
    }
}
