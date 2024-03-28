package com.clothing.entities;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//import javax.management.relation.Role;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import org.springframework.security.core.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@NoArgsConstructor
@Data
@ToString
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Userid;

    private String Name;
    private String email;
    private String Password;
    private String Contact;


    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date date;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private List<Role> role;

    @OneToOne(mappedBy = "userdetail",cascade = CascadeType.ALL)
    private Cart cart;



    @Override
    public Collection<?extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = role.stream().map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRole()))
                .collect(Collectors.toList());
        return authorities;
    }

    @Override
    public String getPassword() {
        return Password;
    }

    @Override
    public String getUsername() {
        return email;
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