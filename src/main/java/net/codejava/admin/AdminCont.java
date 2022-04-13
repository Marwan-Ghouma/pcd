package net.codejava.admin;


import net.codejava.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminCont {
    @GetMapping("/admin")
    public String loginPage() {

        return "admin";
    }
}
