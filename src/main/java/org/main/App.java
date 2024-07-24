package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class App {


    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        App app= new App();
        try{
            session.beginTransaction();

            List<Users> users =  session.createQuery("from users").getResultList();
            for (Users temp: users){
                System.out.println(https://github.com/ThembaTman0/HQL-Basics.gittemp);
            }
        }finally {
            session.close();
            factory.close();
        }
    }

}
