package com.eleven.dao;

import com.eleven.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by User on 2017/11/16.
 */
@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer,User> implements UserDao{

    public User findById(Integer id) {
        return getByKey(id);
    }

    public User findByUserName(String username) {
        System.out.print(">>>>>>"+username);
        Criteria cri = createEntityCriteria();
        cri.add(Restrictions.eq("userName",username));
        System.out.print(">>>>>>"+(User) cri.uniqueResult());
        return (User) cri.uniqueResult();
    }

    public void save(User user) {
        persist(user);
    }

    public List<User> findAll() {
        Criteria cri = createEntityCriteria();
        System.out.print(">>>>>>"+cri.list());
        return  cri.list();
    }

    public void update(User user) {
        updateEntity(user);
    }

    public void deleteUser(User user) {
        delete(user);
    }
}
