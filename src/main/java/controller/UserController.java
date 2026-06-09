package controller;

import model.User;
import net.bytebuddy.matcher.StringMatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import service.UserService;

import javax.validation.Valid;
import java.util.logging.Logger;

@Controller("controller")
public class UserController {

    private static Logger log = Logger.getLogger(UserController.class.getName());

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")  //Отображение данных
    public String getUser(Model model) {
        log.info("=== МЕТОД ВЫЗВАН -> getUser, запуск ===");
        model.addAttribute("userList", userService.findAll());
        model.addAttribute("user", new User());
        return "user";
    }

    @PostMapping("/user/add") //Сохранение нового клиента
    public String postUser(@Valid @ModelAttribute User user,
                            BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("userList", userService.findAll());
            return "user";
        }
        log.info("=== Данные для сохранения получены: name -> " + user.getName() + ", email -> " + user.getEmail() + ", age -> " + user.getAge() + " ===");
        userService.save(user);
        return "redirect:/user";
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        log.info("=== Человек удален :" + userService.findById(id) + " ===");
        userService.deleteById(id);
        return "redirect:/user";
    }

    @GetMapping("/user/update/{id}")  //Редактирование человека
    public String updateUserGet(@PathVariable long id, Model model) {
        log.info("=== МЕТОД ВЫЗВАН -> updateUser, обновление человека ===");
        model.addAttribute("user", userService.findById(id));
        return "user-update";
    }

    @PostMapping("/user/update/{id}")
    public String updateUserPost(@PathVariable long id,
                             @Valid @ModelAttribute User user,
                                 BindingResult bindingResult,
                                 Model model) {
        if (bindingResult.hasErrors()) {
            return "user-update";
        }
        user.setId(id);
        log.info("=== Данные для обновления получены: name -> " + user.getName() + ", email -> " + user.getEmail() + ", age -> " + user.getAge() + " ===");
        userService.update(user);
        return "redirect:/user";
    }
}

