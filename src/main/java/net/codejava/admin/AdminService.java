package net.codejava.admin ;


import net.codejava.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminService  {

    @Autowired
    private AdminRepo repo;


    public List<User> listAll() {return repo.finAll() ;
    }

    public User findByRib(String rib){return repo.findByRib(rib) ;}
}
