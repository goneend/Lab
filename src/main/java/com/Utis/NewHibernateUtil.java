/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Utis;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NewHibernateUtil {

    private static final SessionFactory sessionFactory;
//    private static final ServiceRegistry serviceRegistry;

    static {
        try {
            sessionFactory = new Configuration().configure()
                    .buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception.
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
