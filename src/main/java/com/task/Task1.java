package com.task;

import com.Utis.Gruppyi;
import com.Utis.Studentyi;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;
import java.util.List;

public class Task1 {
    private final Session s;

    public Task1(Session s) {
        this.s = s;
    }

    public void getGruppyiBySpetsialnost(String spet) {
        Transaction t = s.beginTransaction();
        Query query = s.createQuery("from Gruppyi g where g.nazvanie = :name");
        query.setParameter("name", spet);
        List<Gruppyi> q = query.list();
        for (Gruppyi u : q) {
            System.out.println(u.getNazvanie() + "; " + u.getDataFormir() + "; " + u.getStatus() + "; " + u.getShifr() + "; " + u.getKodPlana());
            u.setStatusDate(new Date());
        }
        t.commit();
    }

    public void getCountStudentyiInGruppyi() {
        Transaction t = s.beginTransaction();
        List<Gruppyi> q = s.createQuery("from Gruppyi g").list();
        int count;
        for (Gruppyi u : q) {
            count = 0;
            for (Studentyi st : u.getStudentyis()) {
                if (!st.getStatus().equals("otchislen") && !st.getStatus().equals("otpusk"))
                    count++;
                st.setStatusDate(new Date());
            }
            System.out.println(u.getNazvanie() + ": " + count);
            u.setStatusDate(new Date());
        }
        t.commit();
    }
}
