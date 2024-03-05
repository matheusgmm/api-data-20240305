package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.repositories.UserRepository;
import application.model.User;

@Controller
public class LoginController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserRepository userRepo;

    @RequestMapping("/login")
    public String loginForm(@RequestParam("error") Optional<String> error, Model ui) {
        if(error.isPresent()) {
            ui.addAttribute("error", "Usuário e/ou senha inválido(s)");
        }
        return "login";
    }

    @RequestMapping("/novousr")
    public String newUser() {
        return "newUser";
    }

    @RequestMapping(value = "/novousr", method = RequestMethod.POST)
    public String newUser(@RequestParam("username") String username, @RequestParam("password") String password, @RequestParam("passwordVerify") String passwordVerify) {
        if(!password.equals("") && password.equals(passwordVerify)){
            User user = new User();
            user.setEmail(username);
            user.setPassword(passwordEncoder.encode(password));
            user.setRole("USER");

            userRepo.save(user);
            return "redirect:/";
        }
        return "newUser";
    }
}
