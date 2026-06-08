package controller;

import model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import java.util.List;

@Controller("controller")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")  //Отображение данных
    public String getUser(Model model) {
        System.out.println("=== МЕТОД ВЫЗВАН -> getUser, запуск ===");
        model.addAttribute("userList", userService.findAll());
        return "user";
    }

    @PostMapping("/user/add") //Сохранение нового клиента
    public String postUser(@RequestParam String name,
                          @RequestParam String email,
                          @RequestParam int age) {
        System.out.println("=== Данные для сохранения получены: name -> " + name + ", email -> " + email + ", age -> " + age + " ===");
        userService.save(new User(name, email, age));
        return "redirect:/user";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        System.out.println("=== Человек удален :" + userService.findById(id) + " ===");
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("/user/update/{id}")  //Редактирование человека
    public String updateUserGet(@PathVariable long id, Model model) {
        System.out.println("=== МЕТОД ВЫЗВАН -> updateUser, обновление человека ===");
        model.addAttribute("user", userService.findById(id));
        return "user-update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUserPost(@PathVariable long id,
                             @RequestParam String name,
                             @RequestParam String email,
                             @RequestParam int age) {
        System.out.println("=== Данные для обновления получены: name -> " + name + ", email -> " + email + ", age -> " + age + " ===");
        User user = new User(name, email, age);
        user.setId(id);
        userService.update(user);
        return "redirect:/user";
    }
}

