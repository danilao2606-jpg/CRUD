package service;

import dao.UserDAO;
import model.User;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImp implements UserService{

    private final UserDAO usersDao;

    public UserServiceImp(UserDAO usersDao) {
        this.usersDao = usersDao;
    }

    @Override
    public User findById(Long id) {
        return usersDao.findById(id);
    }

    @Override
    public void save(User user) {
        usersDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return usersDao.findAll();
    }

    @Override
    public void update(User user) {
        usersDao.update(user);
    }

    @Override
    public void deleteById(long id) {
        usersDao.deleteById(id);
    }
}
