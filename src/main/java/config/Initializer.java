package config;

import controller.UserController;
import model.User;
import org.springframework.stereotype.Component;
import service.UserService;

import java.util.logging.Logger;

@Component
public class Initializer {
    private final UserService userService;
    private static Logger log = Logger.getLogger(UserController.class.getName());

    public Initializer(UserService userService) {
        this.userService = userService;
    }

    public void init() {
        if ((userService.findAll().isEmpty())) {
            userService.save(new User("Danila", "da.o@mail.ru", 22));
            userService.save(new User("Milana", "mila.ha@mail.ru", 21));
            userService.save(new User("Valera", "va.www@mail.ru", 20));
            userService.save(new User("Bogdan", "bob.l@mail.ru", 19));
            userService.save(new User("Ilona", "ilona.p@mail.ru", 18));
            log.info("=== База данных инициализирована! ===");
        }
    }
}
