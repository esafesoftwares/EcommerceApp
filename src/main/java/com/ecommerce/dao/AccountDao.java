package com.ecommerce.dao;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ecommerce.model.Accounts;
@Repository
@Transactional
public class AccountDao {

    @Autowired
    private SessionFactory sessionFactory;

    public Accounts findAccount(String userName ) {
        Session session = sessionFactory.getCurrentSession();
        Criteria crit = session.createCriteria(Accounts.class);
        crit.add(Restrictions.eq("userName", userName));
        return (Accounts) crit.uniqueResult();
    }
    public void addAccount(Accounts account) {
        Session session = sessionFactory.getCurrentSession();
        session.save(account);
        session.flush();
    }
}
