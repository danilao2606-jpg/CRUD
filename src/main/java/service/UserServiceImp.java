package service;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDAO usersDao;

    public UserServiceImp(UserDAO usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    @Transactional (readOnly = true)
    public User findById(Long id) {
        return usersDao.findById(id);
    }

    @Override
    @Transactional
    public void save(User user) {
        if (user == null) {
            throw new NullPointerException("Exception: человек для сохранения не найден!");
        }
        usersDao.save(user);
    }

    @Override
    @Transactional (readOnly = true)
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    @Transactional
    public void update(User user) {
        if (user == null) {
            throw new NullPointerException("Exception: человек для изменения не найден!");
        }
        usersDao.update(user);
    }

    @Override
    @Transactional
    public void deleteById(long id) {
        User user = usersDao.findById(id);
        if (user == null) {
            throw new NullPointerException("Exception: человек для удаления не найден!");
        }
        usersDao.deleteById(id);
    }
}
