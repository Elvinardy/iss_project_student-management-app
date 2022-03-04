package com.student_management_app.service;

import java.util.HashSet;
import java.util.Set;

import com.student_management_app.model.JwtRequest;
import com.student_management_app.model.JwtResponse;
import com.student_management_app.model.User;
import com.student_management_app.repository.UserRepository;
import com.student_management_app.utility.JWTutility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtService implements UserDetailsService {

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private JWTutility jwTutility;

    @Autowired
    private AuthenticationManager authenticationManager;

    public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
        String userName = jwtRequest.getUsername();
        String userPassword = jwtRequest.getPassword();
        authenticate(userName, userPassword);

       final UserDetails userDetails = loadUserByUsername(userName);

       String newGeneratedToken = jwTutility.generateToken(userDetails);

       User user = userRepo.findById(userName).get();

       return new JwtResponse(user, newGeneratedToken);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

      User user = userRepo.findById(username).get();

      if(user != null) {
        return new org.springframework.security.core.userdetails.User(
            user.getUserFirstName(),
            user.getUserPassword(),
            getAuthorities(user)
        );
      } else {
        throw new UsernameNotFoundException("Username is not valid!");
      }
    }

    private Set getAuthorities(User user) {
        Set authorities = new HashSet<>();

        user.getRole().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        });

        return authorities;
    }

    private void authenticate(String userName, String userPassword) throws Exception {
        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userName, userPassword));
        } catch (DisabledException e) {
            throw new Exception("User is disabled");
        } catch (BadCredentialsException e) {
            throw new Exception("Bad Credentials from user");
        }
       

    }
    
}
