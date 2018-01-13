package gq.exchangerates.services;

import gq.exchangerates.dao.UserRepository;
import gq.exchangerates.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * Created by Alexey on 13.01.2018.
 */
@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void addUserToDb(){
        if (userRepository.findByUsername("test") == null) {
            userRepository.save(User.getNewUser());
            System.out.println("test user created");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}
