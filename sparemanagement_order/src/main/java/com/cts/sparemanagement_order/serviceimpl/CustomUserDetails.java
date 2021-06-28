package com.cts.sparemanagement_order.serviceimpl;

import com.cts.sparemanagement_order.entity.UserDetailsEntity;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;

@Data
public class CustomUserDetails implements UserDetails {

    UserDetailsEntity userDetailsEntity;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority authority = new SimpleGrantedAuthority(userDetailsEntity.getRole());
        return Arrays.asList(authority);
    }

    @Override
    public String getPassword()
    {
        return userDetailsEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return userDetailsEntity.getUserName();
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
}
