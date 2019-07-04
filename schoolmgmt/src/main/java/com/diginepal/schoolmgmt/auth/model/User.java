package com.diginepal.schoolmgmt.auth.model;


import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name="software_users")
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy= GenerationType. IDENTITY)
    private int id;
    private String email;
    private String password;
    @NonNull
    private Role role;
    private boolean enabled = true;
    private String confirmationToken;

    // User Details
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        Role roleName = this.getRole();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + roleName));
        if (roleName == Role.SUPER_ADMIN) {
            authorities.add(new SimpleGrantedAuthority("ROLE_HEADMASTER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_PARENT"));
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        if (roleName == Role.HEADMASTER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_TEACHER"));
            authorities.add(new SimpleGrantedAuthority("ROLE_PARENT"));
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        if (roleName == Role.TEACHER) {
            authorities.add(new SimpleGrantedAuthority("ROLE_PARENT"));
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        if (roleName == Role.PARENT) {
            authorities.add(new SimpleGrantedAuthority("ROLE_STUDENT"));
        }
        return authorities;
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
    public String getUsername() {
        return email;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
