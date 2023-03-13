package web.service;

import org.springframework.beans.factory.annotation.Autowired;
import web.dao.UserDao;
import web.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public List<User> getUsers(){
        return userDao.getUsers();
    }

    public void create(User user) {
        userDao.create(user);
    }

    public User read(Long id) {
        return userDao.read(id);
    }

    public void update(User user) {
        userDao.update(user);
    }

    public void delete(User user) {
        userDao.delete(user);
    }
}
