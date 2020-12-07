package com.codeup.blogspring.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class UserWithRoles extends User implements UserDetails {

    public UserWithRoles(User user){
        super(user);  // Uses the copy constructor that we purposely built into the user model
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        String roles = "";  // No authorization parts are being used (think RBAC roles)
        return AuthorityUtils.commaSeparatedStringToAuthorityList(roles);
    }

    // Seems odd that these would all be set to return true, but it seems there would need to be additional structure in place to enable logic to happen on the User objects before these methods could serve their intended functions

    @Override
    public boolean isAccountNonExpired(){
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
    public boolean isEnabled(){
        return true;
    }
}
