package hiber.dao;

import hiber.model.Car;
import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    @SuppressWarnings("unchecked")
    public User getUserByCar(Car car) {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User u WHERE u.car.model = :model AND u.car.series = :series");
        query.setParameter("model", car.getModel());
        query.setParameter("series", car.getSeries());

        return query.getResultStream().findFirst().orElse(null);
    }

}
