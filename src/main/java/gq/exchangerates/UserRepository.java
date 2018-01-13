package gq.exchangerates;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by Alexey on 13.01.2018.
 */
public interface UserRepository extends CrudRepository<User, Long>{
    User findByUserName(String userName);
}
