package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    User findById(Long id);

    void save(User user);

    List<User> findAll();

    void update(User user);

    public void deleteById(Long id);
}
