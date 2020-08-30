package example.service;

import example.dao.UserDao;
import example.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public List<User> allUsers() {
        return userDao.allUsers();
    }

    @Transactional
    public void add(User user) {
        userDao.add(user);
    }

    @Transactional
    public void delete(Long id) {
        userDao.delete(id);
    }

    @Transactional
    public void edit(User user) {
        userDao.edit(user);
    }

    @Transactional
    public User getById(Long id) {
        return userDao.getById(id);
    }

}
