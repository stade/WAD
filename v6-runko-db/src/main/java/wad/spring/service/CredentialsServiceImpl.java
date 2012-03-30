package wad.spring.service;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class CredentialsServiceImpl implements CredentialsService {
    
    @Override
    public String getName() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }

        return auth.getName();
    }

    @Override
    public Object getInfo() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null) {
            return null;
        }
        
        return auth.getCredentials();

    }
    
}
