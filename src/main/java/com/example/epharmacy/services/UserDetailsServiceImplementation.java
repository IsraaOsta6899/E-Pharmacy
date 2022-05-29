package com.example.epharmacy.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.example.epharmacy.models.*;
import com.example.epharmacy.repositories.*;
@Service
public class UserDetailsServiceImplementation implements UserDetailsService {
    private UserRepo userRepository;
    
    public UserDetailsServiceImplementation(UserRepo userRepository){
        this.userRepository = userRepository;
    }
    // 1
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByEmail(email);
        User user2=user.get();
        
        if(user2 == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return new org.springframework.security.core.userdetails.User(user2.getUserName(), user2.getPassword(), getAuthorities(user2));
    }
    
    // 2
    private List<GrantedAuthority> getAuthorities(User user){
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
         
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().getName());
            authorities.add(grantedAuthority);
        
        return authorities;
    
}
}