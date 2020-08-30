package example.dao;

import example.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager em;

    @PersistenceContext
    private EntityManager entityManager;

    @SuppressWarnings("unchecked")
    public List<User> allUsers() {
        return entityManager.createQuery("from " + User.class.getName()).getResultList();
    }

    public void add(User user) {
        entityManager.persist(user);
    }

    public void delete(Long id) {
        entityManager.remove(entityManager.find(User.class, id));
    }

    public void edit(User user) {
        entityManager.merge(user);
    }

    public User getById(Long id) {
        return entityManager.find(User.class, new Long(id));
    }
}

