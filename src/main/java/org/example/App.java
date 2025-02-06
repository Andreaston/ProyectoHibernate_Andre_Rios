package org.example;

/**
 * Hello world!
 *
 */

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Test");
        Session session = HibernateUtil.get().openSession();

        session.close();
        System.out.println("Finalizao");

    }
}
