package config;

import model.User;
import org.springframework.stereotype.Component;
import service.UserService;

@Component
public class Main {
    private final UserService userService;

    public Main (UserService userService) {
        this.userService = userService;
    }

    public void init() {
        if ((userService.findAll().isEmpty())) {
            userService.save(new User("Danila", "da.o@mail.ru", 22));
            userService.save(new User("Milana", "mila.ha@mail.ru", 21));
            userService.save(new User("Valera", "va.www@mail.ru", 20));
            userService.save(new User("Bogdan", "bob.l@mail.ru", 19));
            userService.save(new User("Ilona", "ilona.p@mail.ru", 18));
            System.out.println("=== База данных инициализирована! ===");
        }
    }
}
