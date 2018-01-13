package gq.exchangerates;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Alexey on 13.01.2018.
 */

//not userd class
@Component
public class UserDao {

    @Autowired
    private UserRepository userRepository;

    public User findByUserName(String username) {
        return null;
    }


}
