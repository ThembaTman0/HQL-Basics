package org.main;

import org.entity.Users;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class Read {


    public static void main(String[] args){
        SessionFactory factory =new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Users.class).buildSessionFactory();
        Session session = factory.getCurrentSession();
        try{
            session.beginTransaction();

            List<Users> users =  session.createQuery("from users where username = 'Jonh' OR "+
                    "password like '%1'").getResultList();
            for (Users temp: users){
                System.out.println(temp);
            }
        }finally {
            session.close();
            factory.close();
        }
    }

}
