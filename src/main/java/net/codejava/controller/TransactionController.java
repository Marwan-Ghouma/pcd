package net.codejava.controller;

import net.codejava.CustomUserDetails;
import net.codejava.User;
import net.codejava.UserServices;
import net.codejava.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import net.codejava.service.TransactionService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.List;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
public class TransactionController {

    @Autowired
    public TransactionService service ;
    @Autowired
    public UserServices userServices;


    @PostMapping("/trans")
    public Transaction addCheque(@RequestBody Transaction cheque){
        return service.saveCheque(cheque);
    }
    @GetMapping("/listCheques/{id}")
    public List<Transaction> getListTransaction(@PathVariable long id){

        return userServices.getById(id).getTransactionList();
    }
    @GetMapping("/admin/cheques/{id}")
    public List<Transaction> findAllCheque(@PathVariable long id){
        return service.getAdminCheques(id);
    }
    @GetMapping("/cheque/{id}")
    public List<Transaction> findByIdClient(@PathVariable long id){
        return service.getClientCheques(id);
    }

    @GetMapping("/name")
    public Object findName (User user){
       return user;

    }
    @GetMapping("/user")
    public List<Transaction> current(HttpServletRequest request) {
        String id = request.getRemoteUser();
        System.out.print(id);
        return userServices.getByEmail(id).getTransactionList();
    }

    @GetMapping("/aco")
    public String viewUserAccountForm(
            @AuthenticationPrincipal CustomUserDetails userDetails ) {
        String userEmail = userDetails.getUsername();
        User user = userServices.getByEmail(userEmail);


        return user.getFullName();
    }



}
