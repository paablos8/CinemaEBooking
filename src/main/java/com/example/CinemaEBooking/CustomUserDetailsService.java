package com.example.CinemaEBooking;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.Database.UserTableConnector;
import com.example.CinemaEBooking.entities.Status;

public class CustomUserDetailsService implements UserDetailsService{

    private UserTableConnector utc;

    @Override
    public UserDetails loadUserByUsername(String userId) throws UsernameNotFoundException {
        int userIdInt = Integer.parseInt(userId);
        String userFirstName = utc.getUserFirstName(userIdInt);
        String userLastName = utc.getUserLastName(userIdInt);
        long userPhoneNumber = utc.getUserPhoneNumber(userIdInt);
        int userStatus= utc.getUserStatus(userIdInt);
        boolean userType = utc.getUserType(userIdInt);
        System.out.println(userFirstName);
            
        if (userFirstName == null) {
            throw new UsernameNotFoundException("User not found");
        }
        
        return null;
    }
    
}
