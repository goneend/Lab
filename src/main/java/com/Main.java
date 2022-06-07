package com;

import com.Utis.NewHibernateUtil;
import com.task.Task1;
import com.task.Task2;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
        SessionFactory sf = NewHibernateUtil.getSessionFactory();
        Session s = sf.openSession();
        Task1 task1 = new Task1(s);
        task1.getGruppyiBySpetsialnost("A-29");
        task1.getCountStudentyiInGruppyi();
        Task2 task2 = new Task2(s);
        task2.moveStudentyi();
        s.close();
        sf.close();
    }

}
