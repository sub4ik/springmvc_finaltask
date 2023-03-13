package web.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import web.model.User;

import java.util.List;

@Repository
@Transactional
public class UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    public List<User> getUsers(){
        return entityManager.createQuery("FROM User", User.class).getResultList();
    }

    public void create(User user) {
        entityManager.persist(user);
    }

    public User read(Long id) {
        return entityManager.find(User.class, id);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }


}
