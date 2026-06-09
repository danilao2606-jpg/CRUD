package service;

import controller.UserController;
import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.logging.Logger;

@Service
public class UserServiceImp implements UserService{
    private static Logger log = Logger.getLogger(UserController.class.getName());

    private final UserDAO usersDao;

    public UserServiceImp(UserDAO usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public User findById(Long id) {
        return usersDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        if (user == null) {
            log.info("Пользователь не найден!");
        }
        usersDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    @Transactional
    public void update(User user) {
        if (user == null) {
            log.info("Пользователь не найден!");
        }
        usersDao.update(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        User user = usersDao.findById(id);
        if (user == null) {
            log.info("Пользователь не найден!");
        }
        usersDao.deleteById(id);
    }
}
