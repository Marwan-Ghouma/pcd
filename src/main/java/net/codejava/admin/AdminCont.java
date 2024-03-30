package net.codejava.admin;


import net.codejava.User;
import net.codejava.UserServices;
import net.codejava.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AdminCont {
    @Autowired
   private AdminService serv;

    @GetMapping("/admin")
    public String adminPage() {

        return "admin";
    }

    @GetMapping("/list")

    public List<User> getAllAdmin(){

        return serv.listAll();
    }

    @GetMapping("/admin/client/{rib}")
    public User findByRib(@PathVariable String rib){
        return serv.findByRib(rib);
    }




}
