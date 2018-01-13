package gq.exchangerates;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by Alexey on 13.01.2018.
 */
public enum Role implements GrantedAuthority {
    USER;


    @Override
    public String getAuthority() {
        return name();
    }
}
