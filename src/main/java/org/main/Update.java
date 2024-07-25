package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Update {


    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            session.createQuery("update users set password ='super_password' "+
                    "where username like 'Jonh%'").executeUpdate();

        }finally {
            session.close();
            factory.close();
        }
    }

}
