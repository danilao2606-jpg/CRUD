package service;

import dao.UserDAO;
import dao.UserDaoHibernate;
import model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    public void save(User user);

    public List<User> findAll();

    public void update(User user);

    public void deleteById(long id);

}
