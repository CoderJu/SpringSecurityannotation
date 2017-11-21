package com.eleven.dao;

import com.eleven.model.User;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

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
}
