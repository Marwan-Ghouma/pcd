package net.codejava.admin ;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminDetailsService implements UserDetailsService {

    @Autowired
    private AdminRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = userRepo.findByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("Admin not found");
        }
        return new net.codejava.admin.AdminDetails(user);
    }

}
