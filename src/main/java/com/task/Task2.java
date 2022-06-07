package com.task;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class Task2 {
    private final Session s;

    public Task2(Session s) {
        this.s = s;
    }

    public void moveStudentyi() {
        Transaction t = s.beginTransaction();
        List<Studentyi> st = s.createQuery("from Studentyi s").list();
        List<Gruppyi> gr = s.createQuery("from Gruppyi g").list();
        Gruppyi gruppyi = new Gruppyi();
        for (Studentyi q : st) {
            if (q.getStatus().equals("otpusk")) {
                gruppyi = q.getGruppyi();
                for (Gruppyi g : gr) {
                    if (gruppyi.getKodSpets() == g.getKodSpets() && gruppyi.getDataFormir().getYear() < g.getDataFormir().getYear()) {
                        q.setStatus("zachislen");
                        q.setGruppyi(g);
                        g.getStudentyis().add(q);
                        s.saveOrUpdate(g);
                        break;
                    }
                }
            }
        }
        t.commit();
    }
}
