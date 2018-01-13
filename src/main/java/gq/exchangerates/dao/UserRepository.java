package gq.exchangerates.dao;

import gq.exchangerates.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alexey on 13.01.2018.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUsername(String username);
}
