package project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.model.User;
import project.service.UserService;

import javax.validation.Valid;


@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public String getAllUser(Model model) {
        model.addAttribute("user", userService.readAllUser());
        return "allUsers";
    }

    @GetMapping("/add")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "formUser";
    }

    @PostMapping("/add")
    public String addUser(@ModelAttribute("user") @Valid User user) {
        userService.createUser(user);
        return "redirect:/users";
    }

    @GetMapping("/edit")
    public String updateUser(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "changeUser";
    }

    @PostMapping("/edit")
    public String updateUser(@Valid User user) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/delete")
    public String deleteUserById(@RequestParam(value = "id", required = false) Long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }

    @GetMapping("/find")
    public String findUserById(@RequestParam(value = "id", required = false) long id, Model model) {
        model.addAttribute("user", userService.readUserById(id));
        return "user";
    }
}